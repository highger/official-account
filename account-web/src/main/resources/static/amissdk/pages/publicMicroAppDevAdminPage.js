var publicMicroAppDevAdminPage = {
    type: "page",
    title: "MicroApp Admin",
    body: [
        {
            type: "crud",
            api: "hostml/amis/micro/apps?platform=DESKTOP&tagCode=LATEST",
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
                    name: "developerCode",
                    label: "developerCode",
                    type: "text",
                },
                {
                    type: "operation",
                    label: "操作",
                    buttons: [
                        {
                            label: "绑定开发者",
                            type: "button",
                            actionType: "dialog",
                            level: "link",
                            className: "text-info",
                            dialog: {
                                title: "微应用绑定开发者",
                                size: "lg",
                                body: {
                                    type: "form",
                                    api: "put:hostml/amis/bind/developer",
                                    body: [
                                        {
                                            name: "microAppCode",
                                            label: "microAppCode",
                                            type: "input-text",
                                        },
                                        {
                                            name: "developerId",
                                            label: "开发者",
                                            type: "select",
                                            searchable: true,
                                            sortable: true,
                                            selectMode: "chained",
                                            source:
                                                "hostml/amis/bind/developer?microAppCode=${microAppCode}&microAppVersion=${version}",
                                        }
                                    ],
                                },
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
