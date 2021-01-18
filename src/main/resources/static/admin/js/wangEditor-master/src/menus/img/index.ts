/**
 * @description 插入、上传图片
 * @author wangfupeng
 */

import PanelMenu from '../menu-constructors/PanelMenu'
import Editor from '../../editor/index'
import $ from '../../utils/dom-core'
import createPanelConf from './create-panel-conf'
import Panel from '../menu-constructors/Panel'
import { MenuActive } from '../menu-constructors/Menu'
import bindEvent from './bind-event/index'

class Image extends PanelMenu implements MenuActive {
    constructor(editor: Editor) {
        const $elem = $(
            '<div class="w-e-menu" data-title="图片"><i class="w-e-icon-image"></i></div>'
        )
        super($elem, editor)

        // 绑定事件，如粘贴图片
        bindEvent(editor)
    }

    /**
     * 菜单点击事件
     */
    public clickHandler(): void {
        this.createPanel()
    }

    /**
     * 创建 panel
     */
    private createPanel(): void {
        const conf = createPanelConf(this.editor)
        const panel = new Panel(this, conf)
        panel.create()
    }

    /**
     * 尝试修改菜单 active 状态
     */
    public tryChangeActive() {}
}

export default Image
