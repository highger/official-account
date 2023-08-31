var businessSaasAdminPage = {
    type: "page",
    title: "businessSaas Admin",
    body: [
        {
            type: "crud",
            api: "hostml/amis/oem/saas?projectType=SMART_BUSINESS",
            syncLocation: false,
            columns: [
                {
                    name: "id",
                    label: "id",
                    type: "text",
                },
                {
                    name: "name",
                    label: "name",
                    type: "text",
                },
                {
                    name: "host",
                    label: "host",
                    type: "text",
                },
                {
                    label: "projectCode",
                    name: "projectCode",
                    type: "text",
                },
                {
                    label: "projectType",
                    name: "projectType",
                    type: "text",
                },
                {
                    label: "titleZh",
                    name: "titleZh",
                    type: "text",
                },
                {
                    label: "titleEn",
                    name: "titleEn",
                    type: "text",
                },
                {
                    label: "label",
                    name: "label",
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
                                    api: "put:hostml/amis/oem/saas",
                                    body: [
                                        {
                                            name: "id",
                                            label: "id",
                                            type: "input-text",
                                        },
                                        {
                                            name: "name",
                                            label: "name",
                                            type: "input-text",
                                        },
                                        {
                                            name: "host",
                                            label: "host",
                                            type: "input-text",
                                        },
                                        {
                                            label: "projectCode",
                                            name: "projectCode",
                                            type: "input-text",
                                        },
                                        {
                                            label: "projectType",
                                            name: "projectType",
                                            type: "input-text",
                                            options: [
                                                {
                                                    label: "SMART_BUSINESS",
                                                    value: "SMART_BUSINESS"
                                                }
                                            ],
                                        },
                                        {
                                            label: "titleZh",
                                            name: "titleZh",
                                            type: "input-text",
                                        },
                                        {
                                            label: "titleEn",
                                            name: "titleEn",
                                            type: "input-text",
                                        },
                                        {
                                            label: "logo",
                                            name: "logo",
                                            type: "input-text",
                                            options: [
                                                {
                                                    label: "https://promotion-static.tuyacn.com/static/242969466160533504.png",
                                                    value: "https://promotion-static.tuyacn.com/static/242969466160533504.png"
                                                }
                                            ]
                                        },
                                        {
                                            label: "favicon",
                                            name: "favicon",
                                            type: "input-text"
                                        },
                                        {
                                            label: "bgImage",
                                            name: "bgImage",
                                            type: "input-text",
                                            options: [
                                                {
                                                    label: "https://images.tuyacn.com/rms-static/537a3fd0-1b5a-11ec-b7af-2d39f353debc-1632283530317.jpg?tyName=login.jpg",
                                                    value: "https://images.tuyacn.com/rms-static/537a3fd0-1b5a-11ec-b7af-2d39f353debc-1632283530317.jpg?tyName=login.jpg"
                                                }
                                            ]
                                        },
                                        {
                                            label: "label",
                                            name: "label",
                                            type: "input-text",
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
                                body: {
                                    type: "form",
                                    body: [
                                        {
                                            name: "id",
                                            label: "id",
                                            type: "input-text",
                                        },
                                        {
                                            name: "name",
                                            label: "name",
                                            type: "input-text",
                                        },
                                        {
                                            name: "host",
                                            label: "host",
                                            type: "input-text",
                                        },
                                        {
                                            label: "projectCode",
                                            name: "projectCode",
                                            type: "input-text",
                                        },
                                        {
                                            label: "projectType",
                                            name: "projectType",
                                            type: "input-text",
                                        },
                                        {
                                            label: "titleZh",
                                            name: "titleZh",
                                            type: "input-text",
                                        },
                                        {
                                            label: "titleEn",
                                            name: "titleEn",
                                            type: "input-text",
                                        },
                                        {
                                            label: "logo",
                                            name: "logo",
                                            type: "input-text"
                                        },
                                        {
                                            label: "favicon",
                                            name: "favicon",
                                            type: "input-text"
                                        },
                                        {
                                            label: "bgImage",
                                            name: "bgImage",
                                            type: "input-text"
                                        },
                                        {
                                            label: "label",
                                            name: "label",
                                            type: "input-text",
                                        },
                                    ],
                                },
                            },
                        },
                        {
                            type: "button",
                            label: "开通桌面端微应用",
                            actionType: "dialog",
                            className: "text-success",
                            dialog: {
                                title: "开通桌面端微应用",
                                size: "lg",
                                body: {
                                    type: "form",
                                    api: "put:hostml/amis/oem/apps?saasId=${id}&projectCode=${projectCode}&microIds=${microIds}&platform=DESKTOP",
                                    body: {
                                        type: "wrapper",
                                        body: {
                                            label: "桌面端微应用开通列表",
                                            type: "transfer",
                                            name: "microIds",
                                            searchable: true,
                                            sortable: true,
                                            selectMode: "tree",
                                            source:
                                                "hostml/amis/oem/apps?saasId=${id}&platform=DESKTOP",
                                        },
                                    },
                                },
                            },
                        },
                        {
                            type: "button",
                            label: "开通移动端微应用",
                            actionType: "dialog",
                            className: "text-success",
                            dialog: {
                                title: "开通移动端微应用",
                                size: "lg",
                                body: {
                                    type: "form",
                                    api: "put:hostml/amis/oem/apps?saasId=${id}&projectCode=${projectCode}&microIds=${microIds}&platform=MOBILE",
                                    body: {
                                        type: "wrapper",
                                        body: {
                                            label: "移动端微应用开通列表",
                                            type: "transfer",
                                            name: "microIds",
                                            searchable: true,
                                            sortable: true,
                                            selectMode: "tree",
                                            source:
                                                "hostml/amis/oem/apps?saasId=${id}&platform=MOBILE",
                                        },
                                    },
                                },
                            },
                        },
                        {
                            type: "button",
                            label: "开通小程序端微应用",
                            actionType: "dialog",
                            className: "text-success",
                            dialog: {
                                title: "开通小程序端微应用",
                                size: "lg",
                                body: {
                                    type: "form",
                                    api: "put:hostml/amis/oem/apps?saasId=${id}&projectCode=${projectCode}&microIds=${microIds}&platform=TUYA-MINI-PROGRAM",
                                    body: {
                                        type: "wrapper",
                                        body: {
                                            label: "小程序端微应用开通列表",
                                            type: "transfer",
                                            name: "microIds",
                                            searchable: true,
                                            sortable: true,
                                            selectMode: "tree",
                                            source:
                                                "hostml/amis/oem/apps?saasId=${id}&platform=TUYA-MINI-PROGRAM",
                                        },
                                    },
                                },
                            },
                        },
                    ],
                },
                {
                    type: "operation",
                    label: "菜单自定义",
                    buttons: [
                        {
                            type: "button",
                            label: "自定义菜单(DESKTOP)",
                            actionType: "dialog",
                            className: "text-success",
                            dialog: {
                                title: "自定义菜单",
                                size: "lg",
                                body: {
                                    "type": "crud",
                                    "syncLocation": false,
                                    "api": "hostml/amis/entry/list?oemSaasId=${id}&platform=DESKTOP",
                                    "saveOrderApi": "hostml/amis/entry/priority",
                                    "draggable": true,
                                    primaryField: "id",
                                    "columns": [
                                        {
                                            label: "priority",
                                            name: "priority"
                                        },
                                        {
                                            label: "id",
                                            name: "id"
                                        },
                                        {
                                            label: "nameZh",
                                            name: "nameZh"
                                        },
                                        {
                                            label: "nameEn",
                                            name: "nameEn"
                                        },
                                        {
                                            label: "icon",
                                            name: "icon"
                                        },
                                        {
                                            label: "type",
                                            name: "type"
                                        },

                                        {
                                            label: "platform",
                                            name: "platform"
                                        },
                                        {
                                            label: "oemSaasId",
                                            name: "oemSaasId"
                                        },
                                        {
                                            label: "oemMicroAppId",
                                            name: "oemMicroAppId"
                                        },
                                    ]
                                }
                            },
                        },
                        {
                            type: "button",
                            label: "自定义菜单(QuickStart)",
                            actionType: "dialog",
                            className: "text-success",
                            dialog: {
                                title: "自定义菜单(QuickStart)",
                                size: "lg",
                                body: {
                                    "type": "crud",
                                    "syncLocation": false,
                                    "api": "hostml/amis/entry/list?oemSaasId=${id}&platform=MOBILE&type=101",
                                    "saveOrderApi": "hostml/amis/entry/priority",
                                    "draggable": true,
                                    primaryField: "id",
                                    "columns": [
                                        {
                                            label: "priority",
                                            name: "priority"
                                        },
                                        {
                                            label: "id",
                                            name: "id"
                                        },
                                        {
                                            label: "nameZh",
                                            name: "nameZh"
                                        },
                                        {
                                            label: "nameEn",
                                            name: "nameEn"
                                        },
                                        {
                                            label: "icon",
                                            name: "icon"
                                        },
                                        {
                                            label: "type",
                                            name: "type"
                                        },

                                        {
                                            label: "platform",
                                            name: "platform"
                                        },
                                        {
                                            label: "oemSaasId",
                                            name: "oemSaasId"
                                        },
                                        {
                                            label: "oemMicroAppId",
                                            name: "oemMicroAppId"
                                        },
                                    ]
                                }
                            },
                        },
                        {
                            type: "button",
                            label: "自定义菜单(Widget)",
                            actionType: "dialog",
                            className: "text-success",
                            dialog: {
                                title: "自定义菜单",
                                size: "lg",
                                body: {
                                    "type": "crud",
                                    "syncLocation": false,
                                    "api": "hostml/amis/entry/list?oemSaasId=${id}&platform=MOBILE&type=102",
                                    "saveOrderApi": "hostml/amis/entry/priority",
                                    "draggable": true,
                                    primaryField: "id",
                                    "columns": [
                                        {
                                            label: "priority",
                                            name: "priority"
                                        },
                                        {
                                            label: "id",
                                            name: "id"
                                        },
                                        {
                                            label: "nameZh",
                                            name: "nameZh"
                                        },
                                        {
                                            label: "nameEn",
                                            name: "nameEn"
                                        },
                                        {
                                            label: "icon",
                                            name: "icon"
                                        },
                                        {
                                            label: "ratio",
                                            name: "ratio"
                                        },
                                        {
                                            label: "type",
                                            name: "type"
                                        },

                                        {
                                            label: "platform",
                                            name: "platform"
                                        },
                                        {
                                            label: "oemSaasId",
                                            name: "oemSaasId"
                                        },
                                        {
                                            label: "oemMicroAppId",
                                            name: "oemMicroAppId"
                                        },
                                    ]
                                }
                            },
                        },
                    ],
                }
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
                            api: "post:hostml/amis/oem/saas",
                            body: [
                                {
                                    name: "name",
                                    label: "name",
                                    type: "input-text",
                                },
                                {
                                    name: "host",
                                    label: "host",
                                    type: "input-text",
                                },
                                {
                                    label: "projectCode",
                                    name: "projectCode",
                                    type: "input-text",
                                },
                                {
                                    label: "projectType",
                                    name: "projectType",
                                    type: "input-text",
                                    options: [
                                        {
                                            label: "SMART_BUSINESS",
                                            value: "SMART_BUSINESS"
                                        }
                                    ],
                                },
                                {
                                    label: "titleZh",
                                    name: "titleZh",
                                    type: "input-text",
                                },
                                {
                                    label: "titleEn",
                                    name: "titleEn",
                                    type: "input-text",
                                },
                                {
                                    label: "logo",
                                    name: "logo",
                                    type: "input-text",
                                    options: [
                                        {
                                            label: "https://promotion-static.tuyacn.com/static/242969466160533504.png",
                                            value: "https://promotion-static.tuyacn.com/static/242969466160533504.png"
                                        }
                                    ]
                                },
                                {
                                    label: "favicon",
                                    name: "favicon",
                                    type: "input-text"
                                },
                                {
                                    label: "bgImage",
                                    name: "bgImage",
                                    type: "input-text",
                                    options: [
                                        {
                                            label: "https://images.tuyacn.com/rms-static/537a3fd0-1b5a-11ec-b7af-2d39f353debc-1632283530317.jpg?tyName=login.jpg",
                                            value: "https://images.tuyacn.com/rms-static/537a3fd0-1b5a-11ec-b7af-2d39f353debc-1632283530317.jpg?tyName=login.jpg"
                                        }
                                    ]
                                },
                                {
                                    label: "label",
                                    name: "label",
                                    type: "input-text",
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
                        label: "Saas - Host:",
                        placeholder: "通过Saas Host域名搜索",
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
            quickSaveApi: "put:hostml/amis/oem/saas",
            quickSaveItemApi: "put:hostml/amis/oem/saas",
        },
    ],
};
