<template>
  <div>
    <h2 style="margin-bottom:20px">添加管理员</h2>
    <el-form :model="form" label-width="80px" ref="form" :rules="rules">
      <el-form-item label="用户名：" prop="username">
        <el-input v-model="form.username" style="width: 20%" placeholder="请输入姓名"></el-input>
      </el-form-item>
      <el-form-item label="密码：" prop="password">
        <el-input v-model="form.password" style="width: 20%" placeholder="请输入密码"></el-input>
      </el-form-item>
      <el-form-item label="电话：" prop="phone">
        <el-input v-model="form.phone" style="width: 20%" placeholder="请输入电话"></el-input>
      </el-form-item>
      <el-form-item label="邮箱：" prop="email">
        <el-input v-model="form.email" style="width: 30%" placeholder="请输入邮箱"></el-input>
      </el-form-item>
    </el-form>

    <div style="margin-left:25px">

      <el-button type="primary" @click="save">提交</el-button>
      <el-button type="danger" @click="reset()">重置</el-button>
    </div>

  </div>
</template>

<script>

import request from "@/utils/request"

export default {
  name: "AddAdmin",
  data() {
      const checkPhone = (rule, value, callback) => {
        if (!/^[1][3,4,5,6,7,8,9][0-9]{9}$/.test(value)) {
           callback(new Error('请输入合法的手机号'));
        }
        callback()
      };
    return {
      form: {},
      rules: {
        phone: [
        { validator: checkPhone, trigger: 'blur' }
        ]
      }
    }
  },
  methods: {
    save() {
      this.$refs['form'].validate((valid) => {
        if (valid) {
          request.post('/admin/save', this.form)
            .then(res => {
              if (res.code === '200') {
                this.$notify.success('添加成功')
                this.form = {}
              }
            })
        } else {
          this.$notify.error('添加失败!')
          this.$notify.success(res.msg)
        }
      })
    },
    reset(form) {
      this[form] = {};
      this.$nextTick(() => {
        this.$refs['form'].resetFields()
      });
      this.$notify.success('重置成功')
    }
  }
}

</script>

<style scoped>

</style>