var messageTemplatePage = {
    type: "page",
    title: "行业管理",
    body: [
        {
            type: "crud",
            api: "hostml/template/list",
            syncLocation: false,
            columns: [
                {
                    name: "templateId",
                    label: "模版Id",
                    type: "text",
                },
                {
                    name: "title",
                    label: "标题",
                    type: "text",
                },
                {
                    name: "primaryIndustry",
                    label: "主业",
                    type: "text",
                },
                {
                    name: "deputyIndustry",
                    label: "副业",
                    type: "text",
                },
                {
                    name: "content",
                    label: "模版内容",
                    type: "text",
                },
                {
                    name: "example",
                    label: "例子",
                    type: "text",
                },{
                    type: "operation",
                    label: "操作",
                    buttons: [
                        {
                            type: "button",
                            label: "删除",
                            actionType: "ajax",
                            level: "link",
                            className: "text-danger",
                            confirmText: "确定要删除？",
                            api: "delete:hostml/template?templateId=${templateId}",
                        },{
                            label: "发送模版消息",
                            type: "button",
                            actionType: "dialog",
                            level: "link",
                            dialog: {
                                title: "发送模版消息",
                                size: "lg",
                                body: {
                                    type: "form",
                                    api: "post:hostml/template/message/send",
                                    body: [
                                        {
                                            name: "templateId",
                                            label: "templateId",
                                            type: "input-text",
                                        },
                                        {
                                            name: "toUser",
                                            label: "接收用户",
                                            type: "input-text",
                                        },
                                        {
                                            name: "messageData",
                                            label: "消息",
                                            type: "input-text",
                                        }
                                    ],
                                },
                            },
                        }
                    ],
                }
            ],
            itemActions: [],
            features: ["create", "bulkDelete", "filter", "update", "view", "delete"],
            perPageAvailable: [20],
            messages: {
                fetchSuccess: "加载成功",
                fetchFailed: "加载失败",
                quickSaveSuccess: "保存成功",
                quickSaveFailed: "保存失败",
            },
            initFetch: true,
            loadDataOnce: false,
        },
    ],
};
