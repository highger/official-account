var labelAdminPage = {
    type: "page",
    title: "Label Admin",
    body: [
        {
            type: "crud",
            api: "hostml/amis/labels",
            syncLocation: false,
            columns: [
                {
                    name: "id",
                    label: "labelId",
                    type: "text",
                },
                {
                    name: "nameZh",
                    label: "nameZh",
                    type: "text",
                },
                {
                    name: "nameEn",
                    label: "nameEn",
                    type: "text",
                },
                {
                    name: "labelType",
                    label: "labelType",
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
                                size: "lg",
                                body: {
                                    type: "form",
                                    api: "put:hostml/amis/label",
                                    body: [
                                        {
                                            name: "id",
                                            label: "labelId",
                                            type: "input-text",
                                        },
                                        {
                                            name: "nameZh",
                                            label: "nameZh",
                                            type: "input-text",
                                        },
                                        {
                                            name: "nameEn",
                                            label: "nameEn",
                                            type: "input-text",
                                        },
                                        {
                                            name: "labelType",
                                            label: "labelType",
                                            type: "input-text",
                                            options: [
                                                {
                                                    label: "MICRO_APP",
                                                    value: "MICRO_APP"
                                                },
                                                {
                                                    label: "SAAS",
                                                    value: "SAAS"
                                                }
                                            ]
                                        },
                                    ],
                                },
                            },
                        },
                        {
                            label: "查看",
                            type: "button",
                            actionType: "dialog",
                            level: "link",
                            dialog: {
                                title: "查看详情",
                                size: "lg",
                                body: {
                                    type: "form",
                                    body: [
                                        {
                                            name: "id",
                                            label: "labelId",
                                            type: "input-text",
                                        },
                                        {
                                            name: "nameZh",
                                            label: "nameZh",
                                            type: "input-text",
                                        },
                                        {
                                            name: "nameEn",
                                            label: "nameEn",
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
                            api: "delete:hostml/amis/label/${id}",
                        },
                        {
                            type: "button",
                            label: "绑定微应用",
                            actionType: "dialog",
                            className: "text-success",
                            dialog: {
                                title: "绑定微应用",
                                size: "lg",
                                body: {
                                    type: "form",
                                    api: "put:hostml/amis/label/bind/${id}?microAppCodes=${microAppCodes}",
                                    body: {
                                        type: "wrapper",
                                        body: {
                                            label: "桌面端微应用开通列表",
                                            type: "transfer",
                                            name: "microAppCodes",
                                            searchable: true,
                                            sortable: true,
                                            source:
                                                "hostml/amis/label/bind/${id}",
                                        },
                                    },
                                },
                            },
                        },
                    ],
                },
            ],
            bulkActions: [
                {
                    type: "button",
                    level: "danger",
                    label: "批量删除",
                    actionType: "ajax",
                    confirmText: "确定要删除？",
                    api: "delete:hostml/amis/label/batch?labelIds=${ids}",
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
                        size: "lg",
                        body: {
                            type: "form",
                            api: "post:hostml/amis/label?nameZh=${nameZh}&nameEn=${nameEn}&labelType=${labelType}",
                            body: [
                                {
                                    name: "nameZh",
                                    label: "nameZh",
                                    type: "input-text",
                                },
                                {
                                    name: "nameEn",
                                    label: "nameEn",
                                    type: "input-text",
                                },
                                {
                                    name: "labelType",
                                    label: "labelType",
                                    type: "input-text",
                                    options: [
                                        {
                                            label: "MICRO_APP",
                                            value: "MICRO_APP"
                                        },
                                        {
                                            label: "SAAS",
                                            value: "SAAS"
                                        }
                                    ]
                                },
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
                        label: "Label Name:",
                        placeholder: "通过Label名称进行搜索",
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
            quickSaveApi: "put:hostml/amis/label",
            quickSaveItemApi: "put:hostml/amis/label",
        },
    ],
};
