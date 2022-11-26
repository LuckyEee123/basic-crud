<template>
  <div>
    <h3>欢迎！{{admin.username}}</h3>
  </div>
</template>

<script>
import Cookies from 'js-cookie'
import request from '@/utils/request'

export default {

  data() {
    return {
      admin : Cookies.get('admin') ? JSON.parse(Cookies.get('admin')) : {}
    }
  },
  created() {
    request.get('/admin/' + this.admin.id).then(res => {
      this.admin = res.data
    })
  }
}

</script>
