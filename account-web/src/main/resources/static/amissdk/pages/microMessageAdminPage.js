var microMessageAdminPage = {
    type: "page",
    title: "Micro Message Admin",
    body: [
        {
            type: "crud",
            api: "hostml/amis/micro/message/list",
            syncLocation: false,
            columns: [
                {
                    name: "id",
                    label: "id",
                    type: "text",
                },
                {
                    name: "messageType",
                    label: "messageType",
                    type: "text",
                    options: [
                        {
                            label: "告警消息",
                            value: 1
                        },
                        {
                            label: "系统消息",
                            value: 3
                        },
                        {
                            label: "业务消息",
                            value: 4
                        }
                    ]
                },
                {
                    name: "microAppCode",
                    label: "microAppCode",
                    type: "text",
                },
                {
                    name: "messageKey",
                    label: "messageKey",
                    type: "text",
                },
                {
                    name: "messageNameZh",
                    label: "messageNameZh",
                    type: "text",
                },
                {
                    name: "messageNameEn",
                    label: "messageNameEn",
                    type: "text",
                },
                {
                    name: "messageRemarkZh",
                    label: "messageRemarkZh",
                    type: "text",
                },
                {
                    name: "messageRemarkEn",
                    label: "messageRemarkEn",
                    type: "text",
                },
                {
                    name: "supportChannels",
                    label: "supportChannels",
                    type: "text",
                },
                {
                    name: "enabled",
                    label: "enabled",
                    type: "checkbox",
                },
                {
                    type: "operation",
                    label: "操作",
                    buttons: [
                        {
                            label: "编辑",
                            type: "button",
                            actionType: "dialog",
                            level: "link",
                            dialog: {
                                title: "编辑",
                                size: "lg",
                                body: {
                                    type: "form",
                                    api: "post:hostml/amis/micro/message/save",
                                    body: [
                                        {
                                            name: "id",
                                            label: "id",
                                            type: "input-text",
                                        },
                                        {
                                            name: "messageType",
                                            label: "messageType",
                                            type: "input-text",
                                            options: [
                                                {
                                                    label: "告警消息",
                                                    value: 1
                                                },
                                                {
                                                    label: "系统消息",
                                                    value: 3
                                                },
                                                {
                                                    label: "业务消息",
                                                    value: 4
                                                }
                                            ]
                                        },
                                        {
                                            name: "microAppCode",
                                            label: "microAppCode",
                                            type: "input-text",
                                        },
                                        {
                                            name: "messageKey",
                                            label: "messageKey",
                                            type: "input-text",
                                        },
                                        {
                                            name: "messageNameZh",
                                            label: "messageNameZh",
                                            type: "input-text",
                                        },
                                        {
                                            name: "messageNameEn",
                                            label: "messageNameEn",
                                            type: "input-text",
                                        },
                                        {
                                            name: "messageRemarkZh",
                                            label: "messageRemarkZh",
                                            type: "input-text",
                                        },
                                        {
                                            name: "messageRemarkEn",
                                            label: "messageRemarkEn",
                                            type: "input-text",
                                        },
                                        {
                                            name: "enabled",
                                            label: "enabled",
                                            type: "checkbox",
                                        },
                                        {
                                            name: "webPushTemplateId",
                                            label: "webPushTemplateId",
                                            type: "input-text",
                                        },
                                        {
                                            name: "appPushTemplateId",
                                            label: "appPushTemplateId",
                                            type: "input-text",
                                        },
                                        {
                                            name: "smsTemplateId",
                                            label: "smsTemplateId",
                                            type: "input-text",
                                        },
                                        {
                                            name: "emailTemplateId",
                                            label: "emailTemplateId",
                                            type: "input-text",
                                        },
                                        {
                                            name: "voiceTemplateId",
                                            label: "voiceTemplateId",
                                            type: "input-text",
                                        },
                                    ],
                                },
                            },
                        },
                        {
                            type: "button",
                            label: "删除",
                            actionType: "ajax",
                            level: "link",
                            className: "text-danger",
                            confirmText: "确定要删除？",
                            api: "delete:hostml/amis/micro/message/${id}",
                        },
                    ]
                }],
            bulkActions: [],
            itemActions: [],
            features: ["create", "bulkDelete", "filter", "update", "view", "delete"],
            headerToolbar: [
                {
                    label: "新增",
                    type: "button",
                    actionType: "dialog",
                    dialog: {
                        title: "新增",
                        size: "lg",
                        body: {
                            type: "form",
                            api: "post:hostml/amis/micro/message/save",
                            body: [
                                {
                                    name: "messageType",
                                    label: "messageType",
                                    type: "input-text",
                                    options: [
                                        {
                                            label: "告警消息",
                                            value: 1
                                        },
                                        {
                                            label: "系统消息",
                                            value: 3
                                        },
                                        {
                                            label: "业务消息",
                                            value: 4
                                        }
                                    ]
                                },
                                {
                                    name: "microAppCode",
                                    label: "microAppCode",
                                    type: "input-text",
                                },
                                {
                                    name: "messageKey",
                                    label: "messageKey",
                                    type: "input-text",
                                },
                                {
                                    name: "messageNameZh",
                                    label: "messageNameZh",
                                    type: "input-text",
                                },
                                {
                                    name: "messageNameEn",
                                    label: "messageNameEn",
                                    type: "input-text",
                                },
                                {
                                    name: "messageRemarkZh",
                                    label: "messageRemarkZh",
                                    type: "input-text",
                                },
                                {
                                    name: "messageRemarkEn",
                                    label: "messageRemarkEn",
                                    type: "input-text",
                                },
                                {
                                    name: "enabled",
                                    label: "enabled",
                                    type: "checkbox",
                                }
                            ],
                        },
                    },
                },
                "bulkActions",
                "pagination",
            ],
            filter: {
                title: "查询条件",
                body: [
                    {
                        type: "input-text",
                        name: "keywords",
                        label: "MicroApp Name:",
                        placeholder: "通过微应用Code进行搜索:",
                        clearable: true,
                    },
                ],
            },
            perPageAvailable: [10],
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
