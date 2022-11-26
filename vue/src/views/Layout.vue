    <template>
        <div>
            <!-- header -->
            <div style="
            height: 60px;
            line-height: 60px;
            background: white;
            margin-bottom: 2px;
            display: flex;
        ">
                <div style="width: 300px">
                    <img src="@/assets/yly-加工.png" style="
            width: 40px;
            height: 40px;
            position: relative;
            top: 10px;
            left: 20px;
            " />
                    <span style="margin-left: 30px; font-size: 24px">加工中...</span>
                </div>
                <div style="flex: 1; text-align: right; padding-right: 30px;">
                    <el-dropdown>
                        <span class="el-dropdown-link" style="cursor: pointer">
                            {{admin.username}}<i class="el-icon-arrow-down el-icon--right"></i>
                        </span>
                        <el-dropdown-menu slot="dropdown" style="margin-top: -10px">
                            <el-dropdown-item>
                                <div @click="logout">退出</div>
                            </el-dropdown-item>
                        </el-dropdown-menu>
                    </el-dropdown>
                </div>
            </div>


            <!-- 侧边栏&主体 -->
            <div style="display: flex">
                <!-- 侧边栏 -->
                <div style="
            width: 200px;
            min-height: calc(100vh - 62px);
            overflow: hidden;
            margin-right: 2px;
            background-color: white;
            ">
                    <el-menu router class="el-menu-demo" :default-active="$route.path">
                        <el-menu-item index="/">
                            <img src="@/assets/index-logo.png" style="width:20px;height:20px;" />
                            首页
                        </el-menu-item>
                        <el-submenu index="/userManage">
                            <template slot="title">
                                <i class="el-icon-user-solid" style="color:#333333"></i>
                                用户管理
                            </template>
                            <el-menu-item index="/user">
                                <i class="el-icon-s-unfold" style="color:#333333"></i>
                                用户列表
                            </el-menu-item>
                            <el-menu-item index="/addUser">
                                <i class="el-icon-circle-plus-outline" style="color:#333333"></i>
                                添加用户
                            </el-menu-item>
                        </el-submenu>
                        <el-submenu index="/adminManage">
                            <template slot="title">
                                <i class="el-icon-user-solid" style="color:#333333"></i>
                                管理员管理
                            </template>
                            <el-menu-item index="/admin">
                                <i class="el-icon-s-unfold" style="color:#333333"></i>
                                管理员列表
                            </el-menu-item>
                            <el-menu-item index="/addAdmin">
                                <i class="el-icon-circle-plus-outline" style="color:#333333"></i>
                                添加管理员
                            </el-menu-item>
                        </el-submenu>
                    </el-menu>
                </div>

                <!-- 主体 -->
                <div style="flex: 1; background-color: white; padding: 10px;">
                    <router-view />
                </div>
            </div>
        </div>
    </template>

    <script>
    import Cookies from 'js-cookie'

    export default {
        name: "Layout",
        data() {
            return {
                admin: Cookies.get('admin') ? JSON.parse(Cookies.get('admin')) : {}
            }
        },
        methods: {
            logout() {
                Cookies.remove('admin')
                this.$router.push('/login')
            }
        }
    }

    </script>

    <style scoped>

    </style>