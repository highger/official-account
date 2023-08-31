var templateAdminPage = {
    type: "page",
    title: "oem Template Admin",
    body: [
        {
            type: "crud",
            api: "hostml/amis/templates",
            primaryField: "templateId",
            syncLocation: false,
            columns: [
                {
                    name: "templateId",
                    label: "templateId",
                    type: "text",
                },
                {
                    name: "templateName",
                    label: "templateName",
                    type: "text",
                },
                {
                    name: "templateCode",
                    label: "templateCode",
                    type: "text",
                },
                {
                    label: "templateSaasId",
                    name: "saasId",
                    type: "text",
                },
                {
                    label: "saasName",
                    name: "saasName",
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
                                size: "lg",
                                body: {
                                    type: "form",
                                    api: "put:hostml/amis/template",
                                    body: [
                                        {
                                            name: "templateId",
                                            label: "templateId",
                                            type: "input-text",
                                        },
                                        {
                                            name: "templateName",
                                            label: "templateName",
                                            type: "input-text",
                                        },
                                        {
                                            name: "templateNameEn",
                                            label: "templateNameEn",
                                            type: "input-text",
                                        },
                                        {
                                            name: "templateType",
                                            label: "templateType",
                                            type: "select",
                                            "options": [
                                                {
                                                    "label": "static",
                                                    "value": "static"
                                                },
                                                {
                                                    "label": "dynamic",
                                                    "value": "dynamic"
                                                }
                                            ],
                                            "multiple": false
                                        },
                                        {
                                            name: "scope",
                                            label: "scope",
                                            type: "select",
                                            "options": [
                                                {
                                                    "label": "PRIVATE",
                                                    "value": "PRIVATE"
                                                },
                                                {
                                                    "label": "PUBLIC",
                                                    "value": "PUBLIC"
                                                }
                                            ],
                                            "multiple": false
                                        },
                                        {
                                            name: "cardPicture",
                                            label: "cardPicture",
                                            type: "input-text",
                                        },
                                        {
                                            "type": "textarea",
                                            "label": "introduction",
                                            "name": "introduction"
                                        },
                                        {
                                            "type": "textarea",
                                            "label": "introductionEn",
                                            "name": "introductionEn"
                                        },
                                        {
                                            name: "templateCode",
                                            label: "templateCode",
                                            type: "input-text",
                                        },
                                        {
                                            label: "templateSaasId",
                                            name: "saasId",
                                            type: "input-text",
                                        },
                                        {
                                            label: "saasName",
                                            name: "saasName",
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
                                            name: "templateId",
                                            label: "templateId",
                                            type: "input-text",
                                        },
                                        {
                                            name: "templateName",
                                            label: "templateName",
                                            type: "input-text",
                                        },
                                        {
                                            name: "templateNameEn",
                                            label: "templateNameEn",
                                            type: "input-text",
                                        },
                                        {
                                            name: "templateType",
                                            label: "templateType",
                                            type: "input-text"
                                        },
                                        {
                                            name: "scope",
                                            label: "scope",
                                            type: "input-text"
                                        },
                                        {
                                            name: "cardPicture",
                                            label: "cardPicture",
                                            type: "input-text",
                                        },
                                        {
                                            "type": "textarea",
                                            "label": "introduction",
                                            "name": "introduction"
                                        },
                                        {
                                            "type": "textarea",
                                            "label": "introductionEn",
                                            "name": "introductionEn"
                                        },
                                        {
                                            name: "templateCode",
                                            label: "templateCode",
                                            type: "input-text",
                                        },
                                        {
                                            label: "templateSaasId",
                                            name: "saasId",
                                            type: "input-text",
                                        },
                                        {
                                            label: "saasName",
                                            name: "saasName",
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
                                            type: "input-text",
                                        },
                                        {
                                            label: "favicon",
                                            name: "favicon",
                                            type: "input-text",
                                        },
                                        {
                                            label: "bgImage",
                                            name: "bgImage",
                                            type: "input-text",
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
                            label: "删除",
                            actionType: "ajax",
                            level: "link",
                            className: "text-danger",
                            confirmText: "确定要删除？",
                            api: "delete:hostml/amis/template/${templateId}",
                        }
                    ],
                },
                {
                    type: "operation",
                    label: "实例化",
                    buttons: [
                        {
                            type: "button",
                            label: "实例化模板",
                            className: "text-info",
                            actionType: "dialog",
                            dialog: {
                                title: "实例化模板",
                                size: "lg",
                                body: {
                                    type: "form",
                                    api: "post:hostml/amis/template/instance",
                                    body: [
                                        {
                                            label: "templateCode",
                                            name: "templateCode",
                                            type: "input-text",
                                        },
                                        {
                                            label: "projectCode",
                                            name: "projectCode",
                                            type: "input-text",
                                        },
                                        {
                                            label: "iotUserName",
                                            name: "username",
                                            type: "input-text",
                                        }
                                    ],
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
                    api: "delete:hostml/amis/template/batch?templateIds=${ids}",
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
                            api: "post:hostml/amis/template",
                            body: [
                                {
                                    name: "templateName",
                                    label: "templateName",
                                    type: "input-text",
                                },
                                {
                                    name: "templateCode",
                                    label: "templateCode",
                                    type: "input-text",
                                },
                                {
                                    label: "saasName",
                                    name: "saasName",
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
                        label: "Template Name:",
                        placeholder: "通过模板名称进行搜索",
                        clearable: true,
                    },
                    {
                        type: "input-text",
                        name: "templateCode",
                        label: "Template Code:",
                        placeholder: "通过模板编码进行搜索",
                        clearable: true,
                    },
                    {
                        type: "input-text",
                        name: "oemSaasId",
                        label: "Oem SaaS Id:",
                        clearable: true,
                    },
                    {
                        type: "select",
                        name: "templateType",
                        label: "Template Type:",
                        clearable: true,
                        "options": [
                            {
                                "label": "静态模板",
                                "value": "static"
                            },
                            {
                                "label": "动态模板",
                                "value": "dynamic"
                            }
                        ],
                        "multiple": false,
                        "value": "static"
                    },
                    {
                        type: "select",
                        name: "scope",
                        label: "Template Scope:",
                        clearable: true,
                        "options": [
                            {
                                "label": "PRIVATE",
                                "value": "PRIVATE"
                            },
                            {
                                "label": "PUBLIC",
                                "value": "PUBLIC"
                            }
                        ],
                        "multiple": false
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
            quickSaveApi: "put:hostml/amis/template",
            quickSaveItemApi: "put:hostml/amis/template",
        },
    ],
};
