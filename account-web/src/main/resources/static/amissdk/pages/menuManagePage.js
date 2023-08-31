var menuManagePage = {
    type: "page",
    title: "菜单管理",
    body: [
        {
            type: "crud",
            api: "hostml/button",
            syncLocation: false,
            columns: [
                {
                    name: "menu",
                    label: "菜单",
                    type: "text",
                }
            ],
            itemActions: [],
            features: ["create", "bulkDelete", "filter", "update", "view", "delete"],
            headerToolbar: [
                {
                    label: "创建/修改菜单",
                    type: "button",
                    actionType: "dialog",
                    dialog: {
                        title: "创建/修改菜单",
                        size: "lg",
                        body: {
                            type: "form",
                            api: "post:hostml/button?buttonJson=${buttonJson}",
                            body: [
                                {
                                    name: "buttonJson",
                                    label: "菜单",
                                    type: "input-text",
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
