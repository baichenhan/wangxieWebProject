/**
 * @description 服务端路由
 * @author wangfupeng
 */

const router = require('koa-router')()
const saveFiles = require('./controller/save-file')

router.prefix('/api')

// 测试用
router.get('/test', async function (ctx, next) {
    ctx.body = 'hello test'
})

// 上传图片
router.post('/upload-img', async function (ctx, next) {
    const data = await saveFiles(ctx.req)
    ctx.body = data
})

module.exports = router
