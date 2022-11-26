<template>
    <div>
        <div id="app">
            
            <el-result title="404" icon="error" subTitle="抱歉，找不到该页面">

                <template slot="extra">
                    <el-button type="primary" size="medium" @click="$router.push('/home')">返回</el-button>
                </template>
            </el-result>
        
        </div>
    </div>
</template>

<script>
export default {
    name: "404",
    data() {
        return {

        }
    },
    methods: {

    }
}

</script>

<style scoped>

</style>