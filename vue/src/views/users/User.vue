<template>
  <div>
    <div style="margin-bottom:10px">
      <el-input style="width:240px" placeholder="请输入姓名" v-model="params.name"></el-input>
      <el-button style="margin-left:10px" type="primary" @click="load()">
        <i class="el-icon-search">搜索</i>
      </el-button>
      <el-button style="margin-left:10px" type="warning" @click="reset">
        <i class="el-icon-refresh">重置</i>
      </el-button>
    </div>
    <div>
      <el-table :data="tableData" stripe>
        <el-table-column prop="id" label="编号" width="80px"></el-table-column>
        <el-table-column prop="name" label="姓名" width="150px"></el-table-column>
        <el-table-column prop="username" label="卡号" width="130px"></el-table-column>
        <el-table-column prop="sex" label="性别" width="80px"></el-table-column>
        <el-table-column prop="age" label="年龄" width="80px"></el-table-column>
        <el-table-column prop="address" label="地址"></el-table-column>
        <el-table-column prop="phone" label="电话"></el-table-column>


        <el-table-column label="操作">
          <template v-slot="scope">
            <!-- scope.row就是当前行数据 -->
            <el-button type="primary" icon="el-icon-edit" circle @click="$router.push('editUser?id=' + scope.row.id)">
            </el-button>
            <el-popconfirm style="margin-left :5px" title="您确定要删除这行数据吗？" @confirm="del(scope.row.id)">
              <el-button type="danger" icon="el-icon-delete" circle slot="reference"></el-button>
            </el-popconfirm>
          </template>
        </el-table-column>

      </el-table>
    </div>

    <!-- 分页 -->
    <div style="margin-top:20px">
      <el-pagination background :current-page="params.pageNum" :page-size="params.pageSize" layout="prev, pager, next"
        @current-change="currentChange" :total="total">

      </el-pagination>
    </div>

  </div>
</template>

<script>

import request from "@/utils/request";

export default {
  name: 'User',
  data() {
    return {
      tableData: [],
      total: 0,
      params: {
        pageNum: 1,
        pageSize: 10,
        name: ''
      }
    }
  },
  created() {
    this.load()
  },
  methods: {
    // load() {
    //   fetch('http://localhost:6234/user/page')
    //   .then(res => res.json()).then(res => {
    //     console.log(res)
    //     this.tableData = res
    //   })
    // }

    load() {
      request.get('/user/page', {
        params: this.params
      }).then(res => {

        if (res.code === '200') {
          this.tableData = res.data.list
          this.total = res.data.total
        }
      })
    },
    reset() {
      this.params = {
        pageNum: 1,
        pageSize: 10,
        name: ''
      }
      this.load()
    },
    currentChange(pageNum) {
      // 更换页数
      this.params.pageNum = pageNum
      this.load()
    },
    del(id) {
      request.delete("/user/delete/" + id).then(res => {
        if (res.code === '200') {
          this.$notify.success('删除成功')
          this.load()
        } else {
          this.$notify.error(res.msg)
        }
      })
    }
  }
}

</script>

<style scoped>

</style>