<template>
  <div class="app-container">
    <el-form :model="queryParams" ref="queryForm" size="small" :inline="true" v-show="showSearch" label-width="68px">
      <el-form-item label="员工" prop="employeeName">
        <el-input v-model="queryParams.employeeName" placeholder="请输入员工" clearable @keyup.enter.native="handleQuery" />
      </el-form-item>
      <el-form-item label="部门" prop="department">
        <el-select v-model="queryParams.department" placeholder="请选择部门" clearable>
          <el-option v-for="dict in dict.type.spark" :key="dict.value" :label="dict.label" :value="dict.value" />
        </el-select>
      </el-form-item>
      <el-form-item label="老板" prop="bossName">
        <el-input v-model="queryParams.bossName" placeholder="请输入老板" clearable @keyup.enter.native="handleQuery" />
      </el-form-item>
      <el-form-item label="付款方式" prop="payment">
        <el-input v-model="queryParams.payment" placeholder="请输入付款方式" clearable @keyup.enter.native="handleQuery" />
      </el-form-item>
      <el-form-item label="状态" prop="staus">
        <el-select v-model="queryParams.staus" placeholder="请选择状态" clearable>
          <el-option v-for="dict in dict.type.spark_staus" :key="dict.value" :label="dict.label" :value="dict.value" />
        </el-select>
      </el-form-item>
      <el-form-item label="时间">
        <el-date-picker v-model="daterangeCompletionTime" style="width: 240px" value-format="yyyy-MM-dd"
          type="daterange" range-separator="-" start-placeholder="开始日期" end-placeholder="结束日期"></el-date-picker>
      </el-form-item>
      <el-form-item>
        <el-button type="primary" icon="el-icon-search" size="mini" @click="handleQuery">搜索</el-button>
        <el-button icon="el-icon-refresh" size="mini" @click="resetQuery">重置</el-button>
      </el-form-item>
    </el-form>

    <el-row :gutter="10" class="mb8">
      <el-col :span="1.5">
        <el-button type="primary" plain icon="el-icon-plus" size="mini" @click="handleAdd"
          v-hasPermi="['system:invoice:add']">新增</el-button>
      </el-col>
      <el-col :span="1.5">
        <el-button type="success" plain icon="el-icon-edit" size="mini" :disabled="single" @click="handleUpdate"
          v-hasPermi="['system:invoice:edit']">修改</el-button>
      </el-col>
      <el-col :span="1.5">
        <el-button type="danger" plain icon="el-icon-delete" size="mini" :disabled="multiple" @click="handleDelete"
          v-hasPermi="['system:invoice:remove']">删除</el-button>
      </el-col>
      <el-col :span="1.5">
        <el-button type="warning" plain icon="el-icon-download" size="mini" @click="handleExport"
          v-hasPermi="['system:invoice:export']">导出</el-button>
      </el-col>
      <right-toolbar :showSearch.sync="showSearch" @queryTable="getList"></right-toolbar>
    </el-row>

    <el-table v-loading="loading" :data="invoiceList" @selection-change="handleSelectionChange">
      <el-table-column type="selection" width="55" align="center" />
      <el-table-column label="ID" align="center" prop="invoiceId" />
      <el-table-column label="员工" align="center" prop="employeeName" />
      <el-table-column label="部门" align="center" prop="department">
        <template slot-scope="scope">
          <dict-tag :options="dict.type.spark" :value="scope.row.department" />
        </template>
      </el-table-column>
      <el-table-column label="老板" align="center" prop="bossName" />
      <el-table-column label="数量" align="center" prop="quantity" />
      <el-table-column label="单价" align="center" prop="unitPrice" />
      <el-table-column label="礼物" align="center" prop="gift" />
      <el-table-column label="付款方式" align="center" prop="payment" />
      <el-table-column label="总金额" align="center" prop="summoney" />
      <el-table-column label="状态" align="center" prop="staus">
        <template slot-scope="scope">
          <dict-tag :options="dict.type.spark_staus" :value="scope.row.staus" />
        </template>
      </el-table-column>
      <el-table-column label="时间" align="center" prop="completionTime" width="180">
        <!--  <template slot-scope="scope">
          <span>{{ parseTime(scope.row.completionTime, '{y}-{m}-{d}') }}</span>
        </template> -->
      </el-table-column>
      <el-table-column label="备注" align="center" prop="remarks" />
      <el-table-column label="操作" align="center" class-name="small-padding fixed-width">
        <template slot-scope="scope">
          <el-button size="mini" type="text" icon="el-icon-edit" @click="handleUpdate(scope.row)"
            v-hasPermi="['system:invoice:edit']">修改</el-button>
          <el-button size="mini" type="text" icon="el-icon-delete" @click="handleDelete(scope.row)"
            v-hasPermi="['system:invoice:remove']">删除</el-button>
        </template>
      </el-table-column>
    </el-table>

    <pagination v-show="total>0" :total="total" :page.sync="queryParams.pageNum" :limit.sync="queryParams.pageSize"
      @pagination="getList" />

    <!-- 添加或修改单据对话框 -->
    <el-dialog :title="title" :visible.sync="open" width="500px" append-to-body>
      <el-form ref="form" :model="form" :rules="rules" label-width="80px">
        <el-form-item label="员工id" prop="employeeId">
          <el-input v-model="form.employeeId" placeholder="请输入员工id" />
        </el-form-item>
        <el-form-item label="员工" prop="employeeName">
          <el-input v-model="form.employeeName" placeholder="请输入员工" />
        </el-form-item>
        <el-form-item label="部门" prop="department">
          <el-select v-model="form.department" placeholder="请选择部门">
            <el-option v-for="dict in dict.type.spark" :key="dict.value" :label="dict.label"
              :value="dict.value"></el-option>
          </el-select>
        </el-form-item>
        <el-form-item label="老板" prop="bossName">
          <el-input v-model="form.bossName" placeholder="请输入老板" />
        </el-form-item>
        <el-form-item label="数量" prop="quantity">
          <el-input v-model="form.quantity" placeholder="请输入数量" />
        </el-form-item>
        <el-form-item label="单价" prop="unitPrice">
          <el-input v-model="form.unitPrice" placeholder="请输入单价" />
        </el-form-item>
        <el-form-item label="礼物" prop="gift">
          <el-input v-model="form.gift" placeholder="请输入礼物" />
        </el-form-item>
        <el-form-item label="付款方式" prop="payment">
          <el-input v-model="form.payment" placeholder="请输入付款方式" />
        </el-form-item>
        <el-form-item label="会员id" prop="memberId">
          <el-input v-model="form.memberId" placeholder="请输入会员id" />
        </el-form-item>
        <el-form-item label="总金额" prop="summoney">
          <el-input v-model="form.summoney" placeholder="请输入总金额" />
        </el-form-item>
        <el-form-item label="状态" prop="staus">
          <el-select v-model="form.staus" placeholder="请选择状态">
            <el-option v-for="dict in dict.type.spark_staus" :key="dict.value" :label="dict.label"
              :value="parseInt(dict.value)"></el-option>
          </el-select>
        </el-form-item>
        <el-form-item label="时间" prop="completionTime">
          <el-date-picker clearable v-model="form.completionTime" type="date" value-format="yyyy-MM-dd"
            placeholder="请选择时间">
          </el-date-picker>
        </el-form-item>
        <el-form-item label="备注" prop="remarks">
          <el-input v-model="form.remarks" type="textarea" placeholder="请输入内容" />
        </el-form-item>
      </el-form>
      <div slot="footer" class="dialog-footer">
        <el-button type="primary" @click="submitForm">确 定</el-button>
        <el-button @click="cancel">取 消</el-button>
      </div>
    </el-dialog>
  </div>
</template>

<script>
  import {
    listInvoice,
    getInvoice,
    delInvoice,
    addInvoice,
    updateInvoice
  } from "@/api/system/invoice";

  export default {
    name: "Invoice",
    dicts: ['spark_staus', 'spark'],
    data() {
      return {
        // 遮罩层
        loading: true,
        // 选中数组
        ids: [],
        // 非单个禁用
        single: true,
        // 非多个禁用
        multiple: true,
        // 显示搜索条件
        showSearch: true,
        // 总条数
        total: 0,
        // 单据表格数据
        invoiceList: [],
        // 弹出层标题
        title: "",
        // 是否显示弹出层
        open: false,
        // 备注时间范围
        daterangeCompletionTime: [],
        // 查询参数
        queryParams: {
          pageNum: 1,
          pageSize: 10,
          employeeName: null,
          department: null,
          bossName: null,
          payment: null,
          staus: null,
          completionTime: null,
          remarks: null
        },
        // 表单参数
        form: {},
        // 表单校验
        rules: {}
      };
    },
    created() {
      this.getList();
    },
    methods: {
      /** 查询单据列表 */
      getList() {
        this.loading = true;
        this.queryParams.params = {};
        if (null != this.daterangeCompletionTime && '' != this.daterangeCompletionTime) {
          this.queryParams.params["beginCompletionTime"] = this.daterangeCompletionTime[0];
          this.queryParams.params["endCompletionTime"] = this.daterangeCompletionTime[1];
        }
        listInvoice(this.queryParams).then(response => {
          this.invoiceList = response.rows;
          this.total = response.total;
          console.log(response);
          this.loading = false;
        });
      },
      // 取消按钮
      cancel() {
        this.open = false;
        this.reset();
      },
      // 表单重置
      reset() {
        this.form = {
          invoiceId: null,
          employeeId: null,
          employeeName: null,
          department: null,
          bossName: null,
          quantity: null,
          unitPrice: null,
          gift: null,
          payment: null,
          memberId: null,
          summoney: null,
          staus: null,
          completionTime: null,
          remarks: null
        };
        this.resetForm("form");
      },
      /** 搜索按钮操作 */
      handleQuery() {
        this.queryParams.pageNum = 1;
        this.getList();
      },
      /** 重置按钮操作 */
      resetQuery() {
        this.daterangeCompletionTime = [];
        this.resetForm("queryForm");
        this.handleQuery();
      },
      // 多选框选中数据
      handleSelectionChange(selection) {
        this.ids = selection.map(item => item.invoiceId)
        this.single = selection.length !== 1
        this.multiple = !selection.length
      },
      /** 新增按钮操作 */
      handleAdd() {
        this.reset();
        this.open = true;
        this.title = "添加单据";
      },
      /** 修改按钮操作 */
      handleUpdate(row) {
        this.reset();
        const invoiceId = row.invoiceId || this.ids
        getInvoice(invoiceId).then(response => {
          this.form = response.data;
          this.open = true;
          this.title = "修改单据";
        });
      },
      /** 提交按钮 */
      submitForm() {
        this.$refs["form"].validate(valid => {
          if (valid) {
            if (this.form.invoiceId != null) {
              updateInvoice(this.form).then(response => {
                this.$modal.msgSuccess("修改成功");
                this.open = false;
                this.getList();
              });
            } else {
              addInvoice(this.form).then(response => {
                this.$modal.msgSuccess("新增成功");
                this.open = false;
                this.getList();
              });
            }
          }
        });
      },
      /** 删除按钮操作 */
      handleDelete(row) {
        const invoiceIds = row.invoiceId || this.ids;
        this.$modal.confirm('是否确认删除单据编号为"' + invoiceIds + '"的数据项？').then(function() {
          return delInvoice(invoiceIds);
        }).then(() => {
          this.getList();
          this.$modal.msgSuccess("删除成功");
        }).catch(() => {});
      },
      /** 导出按钮操作 */
      handleExport() {
        this.download('system/invoice/export', {
          ...this.queryParams
        }, `invoice_${new Date().getTime()}.xlsx`)
      }
    }
  };
</script>