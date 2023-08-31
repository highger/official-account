var tagPage = {
    type: "page",
    title: "标签管理",
    body: [
        {
            type: "crud",
            api: "hostml/tags",
            syncLocation: false,
            columns: [
                {
                    name: "tagId",
                    label: "tagId",
                    type: "text",
                },
                {
                    name: "name",
                    label: "name",
                    type: "text",
                },
                {
                    name: "count",
                    label: "count",
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
                                    api: "put:hostml/tag?tagId=${tagId}&name=${name}",
                                    body: [
                                        {
                                            name: "tagId",
                                            label: "tagId",
                                            type: "input-text",
                                        },
                                        {
                                            name: "name",
                                            label: "name",
                                            type: "input-text",
                                        }
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
                            api: "delete:hostml/tag?tagId=${tagId}",
                        }
                    ],
                },
            ],
            itemActions: [],
            features: ["create", "bulkDelete", "filter", "update", "view", "delete"],
            headerToolbar: [
                {
                    label: "新增标签",
                    type: "button",
                    actionType: "dialog",
                    dialog: {
                        title: "新增标签",
                        size: "lg",
                        body: {
                            type: "form",
                            api: "post:hostml/tag?name=${name}",
                            body: [
                                {
                                    name: "name",
                                    label: "name",
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
                        name: "tagId",
                        label: "tagId",
                        placeholder: "通过tagId进行搜索",
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
