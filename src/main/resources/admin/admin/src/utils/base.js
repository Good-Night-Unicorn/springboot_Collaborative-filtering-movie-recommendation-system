const base = {
    get() {
        return {
            url : "http://localhost:8080/dianyingtuijianxitong/",
            name: "dianyingtuijianxitong",
            // 退出到首页链接
            indexUrl: 'http://localhost:8080/dianyingtuijianxitong/front/index.html'
        };
    },
    getProjectName(){
        return {
            projectName: "电影推荐系统"
        } 
    }
}
export default base
