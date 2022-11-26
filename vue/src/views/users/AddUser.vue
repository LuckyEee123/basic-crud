<template>
  <div>
    <h2 style="margin-bottom:20px">添加用户</h2>
    <el-form :model="form" label-width="80px" ref="form" :rules="rules">
      <el-form-item label="姓名：" prop="name">
        <el-input v-model="form.name" style="width: 20%" placeholder="请输入姓名"></el-input>
      </el-form-item>
      <el-form-item label="年龄：" prop="age">
        <el-input v-model="form.age" style="width: 20%" placeholder="请输入年龄"></el-input>
      </el-form-item>
      <el-form-item label="性别：" prop="sex">
        <el-radio v-model="form.sex" label="男">男</el-radio>
        <el-radio v-model="form.sex" label="女">女</el-radio>
        <el-radio v-model="form.sex" label="其他">其他</el-radio>
      </el-form-item>
      <el-form-item label="电话：" prop="phone">
        <el-input v-model="form.phone" style="width: 20%" placeholder="请输入电话"></el-input>
      </el-form-item>
      <el-form-item label="地址：" prop="address">
        <el-input v-model="form.address" style="width: 30%" placeholder="请输入地址"></el-input>
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
  name: "AddUser",
  data() {
    const checkAge = (rule, value, callback) => {
        if (!value) {
          return callback(new Error('年龄不能为空'));
        }
        if(!/^[0-9]+$/.test(value)) {
          callback(new Error('请输入数字'));
        }
        if (parseInt(value) > 130 || parseInt(value) <= 0) {
          callback(new Error('请输入合理的年龄'));
        }
        callback()
      };
      const checkPhone = (rule, value, callback) => {
        if (!/^[1][3,4,5,6,7,8,9][0-9]{9}$/.test(value)) {
           callback(new Error('请输入合法的手机号'));
        }
        callback()
      };
    return {
      form: {},
      rules: {
        name: [
          { required: true, message: '请输入姓名', trigger: 'blur' },
          { min: 1, max: 30, message: '姓名长度非法', trigger: 'blur' }
        ],
        age: [
          { validator: checkAge, trigger: 'blur' }
        ],
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
          request.post('/user/save', this.form)
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