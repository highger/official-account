var saasAdminPage = {
    type: "page",
    title: "oem saas Admin",
    body: [
        {
            type: "crud",
            api: "hostml/amis/oem/saas",
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
                    label: "chargeStatus",
                    name: "chargeStatus",
                    type: "text",
                },
                {
                    label: "expireTime",
                    name: "expireTime",
                    type: "datetime",
                },
                {
                    label: "apiChargeModel",
                    name: "apiChargeModel",
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
                                    controls: [
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
                                                    label: "INDUSTRY",
                                                    value: "INDUSTRY"
                                                }
                                            ]
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
                                                    label: "https://images.tuyacn.com/rms-static/5fea5b30-5a5f-11ec-89bb-d7b7de210e4b-1639212621923.png?tyName=default-logo.png",
                                                    value: "https://images.tuyacn.com/rms-static/5fea5b30-5a5f-11ec-89bb-d7b7de210e4b-1639212621923.png?tyName=default-logo.png"
                                                }
                                            ]
                                        },
                                        {
                                            label: "favicon",
                                            name: "favicon",
                                            type: "input-text",
                                            options: [
                                                {
                                                    label: "https://images.tuyacn.com/rms-static/ae9ba1b0-41d4-11ec-89bb-d7b7de210e4b-1636514225995.png?tyName=favicon.png",
                                                    value: "https://images.tuyacn.com/rms-static/ae9ba1b0-41d4-11ec-89bb-d7b7de210e4b-1636514225995.png?tyName=favicon.png"
                                                }
                                            ]
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
                                        {
                                            label: "chargeStatus",
                                            name: "chargeStatus",
                                            type: "input-text",
                                            options: [
                                                {
                                                    label: "长期有效",
                                                    value: "PERMANENT"
                                                },
                                                {
                                                    label: "已开通",
                                                    value: "STABLE"
                                                },
                                                {
                                                    label: "试用中",
                                                    value: "TRIAL"
                                                },
                                                {
                                                    label: "已过期",
                                                    value: "EXPIRED"
                                                }
                                            ]
                                        },
                                        {
                                            type: "datetime",
                                            name: "expireTime",
                                            label: "expireTime"
                                        },
                                        {
                                            label: "apiChargeModel",
                                            name: "apiChargeModel",
                                            type: "input-text",
                                            options: [
                                                {
                                                    label: "微应用开发者",
                                                    value: "MICRO_DEVELOPER"
                                                },
                                                {
                                                    label: "SaaS归属者",
                                                    value: "SAAS_OWNER"
                                                }
                                            ]
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
                            label: "Cookies配置",
                            type: "button",
                            actionType: "dialog",
                            level: "link",
                            dialog: {
                                title: "Cookies配置 ",
                                body: {
                                    type: "form",
                                    api: "put:hostml/amis/cookie/setting",
                                    initApi: "hostml/tags/all",
                                    body: [
                                        {
                                            "name": "saasId",
                                            "label": "saasId",
                                            "type": "input-text",
                                            "required": true
                                        },
                                        {
                                            "type": "select",
                                            "name": "openCookies",
                                            "label": "是否打开cookie",
                                            "required": true,
                                            "options": [
                                                {
                                                    "label": "开启",
                                                    "value": true
                                                },
                                                {
                                                    "label": "关闭",
                                                    "value": false
                                                }
                                            ]
                                        },
                                        {
                                            "type": "input-text",
                                            "name": "ccmKey",
                                            "label": "ccmKey",
                                            "required": true
                                        }
                                    ],
                                },
                            },
                        }, {
                            label: "工业自定义菜单配置",
                            type: "button",
                            actionType: "dialog",
                            level: "link",
                            dialog: {
                                title: "工业自定义菜单配置",
                                body: {
                                    type: "form",
                                    api: "put:hostml/amis/oem/saas/custom/entry/config",
                                    initApi: "hostml/amis/oem/saas/custom/entry/config?saasId=${id}",
                                    body: [
                                        {
                                            name: "id",
                                            label: "id",
                                            type: "input-text",
                                        },
                                        {
                                            name: "enable",
                                            label: "开启桌面端自定义菜单",
                                            type: "checkbox",
                                        },
                                        {
                                            name: "endpoint",
                                            label: "桌面端自定义菜单端点",
                                            type: "input-text",
                                        },
                                        {
                                            name: "enableMobile",
                                            label: "开启移动端自定义菜单",
                                            type: "checkbox",
                                        },
                                        {
                                            name: "endpointMobile",
                                            label: "移动端自定义菜单端点",
                                            type: "input-text",
                                        }
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
                                            label: "INDUSTRY",
                                            value: "INDUSTRY"
                                        }
                                    ]
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
                                            label: "https://images.tuyacn.com/rms-static/5fea5b30-5a5f-11ec-89bb-d7b7de210e4b-1639212621923.png?tyName=default-logo.png",
                                            value: "https://images.tuyacn.com/rms-static/5fea5b30-5a5f-11ec-89bb-d7b7de210e4b-1639212621923.png?tyName=default-logo.png"
                                        }
                                    ]
                                },
                                {
                                    label: "favicon",
                                    name: "favicon",
                                    type: "input-text",
                                    options: [
                                        {
                                            label: "https://images.tuyacn.com/rms-static/ae9ba1b0-41d4-11ec-89bb-d7b7de210e4b-1636514225995.png?tyName=favicon.png",
                                            value: "https://images.tuyacn.com/rms-static/ae9ba1b0-41d4-11ec-89bb-d7b7de210e4b-1636514225995.png?tyName=favicon.png"
                                        }
                                    ]
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
                                {
                                    label: "adminEmail",
                                    name: "username",
                                    type: "input-text",
                                    options: [
                                        {
                                            label: "admin@tuya.com",
                                            value: "admin@tuya.com"
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
                        label: "Saas - Host:",
                        placeholder: "通过Saas Host域名搜索",
                        clearable: true,
                    },
                    {
                        type: "input-text",
                        name: "oemSaasId",
                        label: "SaaS Id:",
                        clearable: true
                    }
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
