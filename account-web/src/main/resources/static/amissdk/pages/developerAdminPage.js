var developerAdminPage = {
    type: "page",
    title: "Developer Admin",
    body: [
        {
            type: "crud",
            api: "hostml/amis/developers",
            syncLocation: false,
            columns: [
                {
                    name: "id",
                    label: "id",
                    type: "text",
                },
                {
                    name: "iotUid",
                    label: "iotUid",
                    type: "text",
                },
                {
                    name: "code",
                    label: "code",
                    type: "text",
                },
                {
                    name: "secretKey",
                    label: "secretKey",
                    type: "text",
                },
                {
                    name: "type",
                    label: "type",
                    type: "text",
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
                                body: {
                                    type: "form",
                                    api: "put:hostml/amis/developer/modify/${id}?type=${type}",
                                    body: [
                                        {
                                            name: "id",
                                            label: "id",
                                            type: "input-text",
                                            "readOnly": true
                                        },
                                        {
                                            name: "type",
                                            label: "type",
                                            type: "input-text",
                                        },
                                    ]
                                },
                            },
                        },
                        {
                            type: "button",
                            label: "重置",
                            actionType: "ajax",
                            level: "link",
                            className: "text-danger",
                            confirmText: "确定要重置该开发者的developerCode和SecretKey？",
                            api: "put:hostml/amis/developer/reset/${id}",
                        },
                        {
                            type: "button",
                            label: "删除",
                            actionType: "ajax",
                            level: "link",
                            className: "text-danger",
                            confirmText: "确定要删除？",
                            api: "delete:hostml/amis/developer/${id}",
                        }
                    ],
                },
            ],
            itemActions: [],
            features: ["create", "bulkDelete", "filter", "update", "view", "delete"],
            headerToolbar: [
                {
                    label: "新增",
                    type: "button",
                    actionType: "dialog",
                    dialog: {
                        title: "新增",
                        body: {
                            type: "form",
                            api: "post:hostml/amis/developer?iotAccount=${iotAccount}&code=${code}&secretKey=${secretKey}&developType=${developType}",
                            body: [
                                {
                                    name: "iotAccount",
                                    label: "iotAccount",
                                    type: "input-text",
                                },
                                {
                                    name: "code",
                                    label: "code",
                                    type: "input-text",
                                },
                                {
                                    name: "secretKey",
                                    label: "secretKey",
                                    type: "input-text",
                                },
                                {
                                    name: "developType",
                                    label: "developType",
                                    type: "input-text",
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
                        label: "Developer Code:",
                        placeholder: "通过Developer Code进行搜索",
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
            quickSaveApi: "put:hostml/amis/developer",
            quickSaveItemApi: "put:hostml/amis/developer",
        },
    ],
}