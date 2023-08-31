var microAppAdminPage = {
    type: "page",
    title: "MicroApp Admin",
    body: [
        {
            type: "crud",
            api: "hostml/amis/micro/apps?platform=DESKTOP&tagCode=STABLE",
            syncLocation: false,
            columns: [
                {
                    name: "tagId",
                    label: "tagId",
                    type: "text",
                },
                {
                    name: "microAppId",
                    label: "microAppId",
                    type: "text",
                },
                {
                    name: "microAppCode",
                    label: "microAppCode",
                    type: "text",
                },
                {
                    name: "microAppName",
                    label: "microAppName",
                    type: "text"
                },
                {
                    name: "version",
                    label: "version",
                    type: "text",
                },
                {
                    name: "publishId",
                    label: "publishId",
                    type: "text",
                },
                {
                    name: "marketNameZh",
                    label: "marketNameZh",
                    type: "text",
                },
                {
                    name: "marketNameEn",
                    label: "marketNameEn",
                    type: "text",
                },
                {
                    name: "appIcon",
                    label: "appIcon",
                    type: "text",
                },
                {
                    name: "descZh",
                    label: "descZh",
                    type: "text",
                },
                {
                    name: "descEn",
                    label: "descEn",
                    type: "text",
                },
                {
                    name: "updateRecordZh",
                    label: "updateRecordZh",
                    type: "text",
                },
                {
                    name: "updateRecordEn",
                    label: "updateRecordEn",
                    type: "text",
                },
                {
                    name: "required",
                    label: "required",
                    type: "checkbox",
                },
                {
                    name: "scope",
                    label: "scope",
                    type: "text"
                },
                {
                    name: "supportMultiTenant",
                    label: "supportMultiTenant",
                    type: "checkbox"
                },
                {
                    name: "zhLabels",
                    label: "zhLabels",
                    type: "text",
                },
                {
                    name: "enLabels",
                    label: "enLabels",
                    type: "text",
                },
                {
                    type: "operation",
                    label: "操作",
                    buttons: [
                        {
                            label: "编辑发布信息",
                            type: "button",
                            actionType: "dialog",
                            level: "link",
                            className: "text-info",
                            dialog: {
                                title: "编辑发布信息",
                                size: "lg",
                                body: {
                                    type: "form",
                                    api: "put:hostml/amis/micro/app/publish",
                                    body: [
                                        {
                                            name: "publishId",
                                            label: "publishId",
                                            type: "input-text",
                                        },
                                        {
                                            name: "microAppCode",
                                            label: "microAppCode",
                                            type: "input-text",
                                        },
                                        {
                                            name: "marketNameZh",
                                            label: "marketNameZh",
                                            type: "input-text",
                                        },
                                        {
                                            name: "marketNameEn",
                                            label: "marketNameEn",
                                            type: "input-text",
                                        },
                                        {
                                            name: "appIcon",
                                            label: "appIcon",
                                            type: "input-text",
                                        },
                                        {
                                            name: "descZh",
                                            label: "descZh",
                                            type: "input-text",
                                        },
                                        {
                                            name: "descEn",
                                            label: "descEn",
                                            type: "input-text",
                                        },
                                        {
                                            name: "required",
                                            label: "required",
                                            type: "checkbox",
                                        },
                                        {
                                            name: "scope",
                                            label: "scope",
                                            type: "input-text",
                                            options: [
                                                {
                                                    label: "public",
                                                    value: "public"
                                                },
                                                {
                                                    label: "private",
                                                    value: "private"
                                                },
                                                {
                                                    label: "hidden",
                                                    value: "hidden"
                                                },
                                            ]
                                        },
                                        {
                                            name: "supportMultiTenant",
                                            label: "supportMultiTenant",
                                            type: "checkbox"
                                        }
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
                                            name: "tagId",
                                            label: "tagId",
                                            type: "input-text",
                                        },
                                        {
                                            name: "microAppId",
                                            label: "microAppId",
                                            type: "input-text",
                                        },
                                        {
                                            name: "microAppCode",
                                            label: "microAppCode",
                                            type: "input-text",
                                        },
                                        {
                                            name: "version",
                                            label: "version",
                                            type: "input-text",
                                        },
                                        {
                                            name: "feResources",
                                            label: "feResources",
                                            type: "input-text"
                                        },
                                        {
                                            name: "publishId",
                                            label: "publishId",
                                            type: "input-text",
                                        },
                                        {
                                            name: "appIcon",
                                            label: "appIcon",
                                            type: "input-text",
                                        },
                                        {
                                            name: "descZh",
                                            label: "descZh",
                                            type: "input-text",
                                        },
                                        {
                                            name: "descEn",
                                            label: "descEn",
                                            type: "input-text",
                                        },
                                        {
                                            name: "required",
                                            label: "required",
                                            type: "checkbox",
                                        },
                                        {
                                            name: "scope",
                                            label: "scope",
                                            type: "input-text"
                                        },

                                        {
                                            name: "zhLabels",
                                            label: "zhLabels",
                                            type: "input-text",
                                        },
                                        {
                                            name: "enLabels",
                                            label: "enLabels",
                                            type: "input-text",
                                        },
                                        {
                                            name: "supportMultiTenant",
                                            label: "supportMultiTenant",
                                            type: "checkbox"
                                        }
                                    ],
                                },
                            },
                        },
                        {
                            type: "button",
                            label: "绑定标签",
                            actionType: "dialog",
                            className: "text-success",
                            dialog: {
                                title: "绑定标签",
                                size: "lg",
                                body: {
                                    type: "form",
                                    api: "put:hostml/amis/micro/app/labels?microAppCode=${microAppCode}&labelIds=${labelIds}",
                                    body: {
                                        type: "wrapper",
                                        body: {
                                            label: "标签列表",
                                            type: "transfer",
                                            name: "labelIds",
                                            searchable: true,
                                            sortable: true,
                                            source:
                                                "hostml/amis/micro/app/labels?microAppCode=${microAppCode}",
                                        },
                                    },
                                },
                            },
                        },
                        {
                            type: "button",
                            label: "绑定云服务",
                            actionType: "dialog",
                            className: "text-success",
                            dialog: {
                                title: "绑定云服务",
                                size: "lg",
                                body: {
                                    type: "form",
                                    api: "put:hostml/amis/micro/app/cloud/service?microAppCode=${microAppCode}&abilityIds=${abilityIds}",
                                    body: {
                                        type: "wrapper",
                                        body: {
                                            label: "云服务列表",
                                            type: "transfer",
                                            name: "abilityIds",
                                            searchable: true,
                                            sortable: true,
                                            source:
                                                "hostml/amis/micro/app/cloud/service?microAppCode=${microAppCode}",
                                        },
                                    },
                                },
                            },
                        },
                        {
                            type: "button",
                            label: "查看微应用API列表",
                            actionType: "dialog",
                            className: "text-success",
                            dialog: {
                                title: "微应用API列表",
                                size: "lg",
                                body: {
                                    "type": "crud",
                                    "syncLocation": false,
                                    "api": "hostml/amis/micro/app/apis?microAppCode=${microAppCode}&version=${version}",
                                    primaryField: "id",
                                    "columns": [
                                        {
                                            label: "id",
                                            name: "id"
                                        },
                                        {
                                            label: "microAppCode",
                                            name: "microAppCode"
                                        },
                                        {
                                            label: "microAppName",
                                            name: "microAppName"
                                        },
                                        {
                                            label: "namespace",
                                            name: "namespace"
                                        },
                                        {
                                            label: "method",
                                            name: "method"
                                        },
                                        {
                                            label: "path",
                                            name: "path"
                                        },

                                        {
                                            label: "permissionCodes",
                                            name: "permissionCodes"
                                        },
                                        {
                                            label: "permissionNames",
                                            name: "permissionNames"
                                        }
                                    ]
                                }
                            },
                        },
                    ],
                },
            ],
            bulkActions: [],
            itemActions: [],
            features: ["create", "bulkDelete", "filter", "update", "view", "delete"],
            headerToolbar: [
                "bulkActions",
                "pagination",
                {
                        "type": "button",
                        "label": "导出微应用开发者信息",
                        "actionType": "ajax",
                        "size": "sm",
                        "api": {
                            "method":"get",
                            "url": "hostml/amis/micro/app/export",
                            "responseType":"blob"
                        }
                }
            ],
            filter: {
                title: "查询条件",
                body: [
                    {
                        type: "input-text",
                        name: "keywords",
                        label: "MicroApp Name:",
                        placeholder: "通过微应用Code或名字进行搜索:",
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
