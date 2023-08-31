var industryPage = {
    type: "page",
    title: "行业管理",
    body: [
        {
            type: "crud",
            api: "hostml/industry",
            syncLocation: false,
            columns: [
                {
                    name: "primaryIndustry",
                    label: "主业",
                    type: "text",
                },
                {
                    name: "secondaryIndustry",
                    label: "副业",
                    type: "text",
                }
            ],
            itemActions: [],
            features: ["create", "bulkDelete", "filter", "update", "view", "delete"],
            headerToolbar: [
                {
                    label: "变更行业",
                    type: "button",
                    actionType: "dialog",
                    dialog: {
                        title: "变更行业",
                        size: "lg",
                        body: {
                            type: "form",
                            api: "post:hostml/industry?primaryIndustry=${primaryIndustry}&secondaryIndustry=${secondaryIndustry}",
                            body: [
                                {
                                    name: "primaryIndustry",
                                    label: "主业",
                                    type: "input-text",
                                    options: [
                                        {
                                            label: "IT科技 互联网/电子商务",
                                            value: "1"
                                        },
                                        {
                                            label: "IT科技 电子技术",
                                            value: "4"
                                        }
                                    ]
                                },
                                {
                                    name: "secondaryIndustry",
                                    label: "副业",
                                    type: "input-text",
                                    options: [
                                        {
                                            label: "IT科技 互联网/电子商务",
                                            value: "1"
                                        },
                                        {
                                            label: "IT科技 电子技术",
                                            value: "4"
                                        }
                                    ]
                                }
                            ],
                        },
                    },
                },
                "bulkActions",
                "pagination",
            ],
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
