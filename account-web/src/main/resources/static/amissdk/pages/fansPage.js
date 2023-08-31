var fansPage = {
    type: "page",
    title: "粉丝管理",
    body: [
        {
            type: "crud",
            api: "hostml/fans/list",
            "primaryField": "openId",
            syncLocation: false,
            columns: [
                {
                    name: "id",
                    label: "id",
                    type: "text",
                },
                {
                    name: "openId",
                    label: "粉丝Id",
                    type: "text",
                },
                {
                    name: "tags",
                    label: "关联的标签",
                    type: "text",
                }
            ],
            bulkActions: [
                {
                    label: "批量添加标签",
                    actionType: "dialog",
                    "dialog": {
                        "title": "批量添加标签",
                        "body": {
                            "type": "form",
                            "api": "post:hostml/tag/add/fans?tagId=${tagId}&ids=${ids}",
                            "body": [
                                {
                                    "type": "hidden",
                                    "name": "ids"
                                },
                                {
                                    name: "tagId",
                                    label: "标签",
                                    type: "select",
                                    searchable: true,
                                    sortable: true,
                                    selectMode: "chained",
                                    source: "hostml/tags/all",
                                }
                            ]
                        }
                    }
                },{
                    label: "批量移除标签",
                    actionType: "dialog",
                    "dialog": {
                        "title": "批量移除标签",
                        "body": {
                            "type": "form",
                            "api": "post:hostml/tag/remove/fans?tagId=${tagId}&ids=${ids}",
                            "body": [
                                {
                                    "type": "hidden",
                                    "name": "ids"
                                },
                                {
                                    name: "tagId",
                                    label: "标签",
                                    type: "select",
                                    searchable: true,
                                    sortable: true,
                                    selectMode: "chained",
                                    source: "hostml/tags/all",
                                }
                            ]
                        }
                    }
                },
            ],
            itemActions: [],
            features: ["create", "bulkDelete", "filter", "update", "view", "delete"],
            filter: {
                title: "查询条件",
                body: [
                    {
                        type: "input-text",
                        name: "openId",
                        label: "openId",
                        placeholder: "通过openId进行搜索",
                        clearable: true,
                    },{
                        name: "tagId",
                        label: "标签",
                        type: "select",
                        searchable: true,
                        sortable: true,
                        clearable: true,
                        selectMode: "chained",
                        source: "hostml/tags/all",
                    }
                ],
            },
            perPageAvailable: [10],
            messages: {
                fetchSuccess: "加载成功",
                fetchFailed: "加载失败"
            },
            initFetch: true,
            loadDataOnce: false,
        },
    ],
};
