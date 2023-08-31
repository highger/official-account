var mediaPage = {
    type: "page",
    title: "素材管理",
    body: [
        {
            type: "crud",
            api: "hostml/temporary/media/list",
            syncLocation: false,
            columns: [
                {
                    name: "id",
                    label: "id",
                    type: "text",
                },
                {
                    name: "mediaModel",
                    label: "mediaModel",
                    type: "text",
                },
                {
                    name: "mediaType",
                    label: "mediaType",
                    type: "text",
                },
                {
                    name: "mediaId",
                    label: "mediaId",
                    type: "text",
                }, {
                    name: "originalUrl",
                    label: "originalUrl",
                    type: "text",
                }, {
                    name: "mediaUrl",
                    label: "mediaUrl",
                    type: "text",
                },
                {
                    type: "operation",
                    label: "操作",
                    buttons: [
                        {
                            type: "button",
                            label: "删除",
                            actionType: "ajax",
                            level: "link",
                            className: "text-danger",
                            confirmText: "确定要删除？",
                            api: "delete:hostml/temporary/media?mediaId=${mediaId}",
                        }
                    ],
                },
            ],
            itemActions: [],
            features: ["create", "bulkDelete", "filter", "update", "view", "delete"],
            headerToolbar: [
                {
                    label: "新增临时素材",
                    type: "button",
                    actionType: "dialog",
                    dialog: {
                        title: "新增临时素材",
                        size: "lg",
                        body: {
                            type: "form",
                            api: "post:hostml/temporary/media?type=${type}&media=${media}",
                            body: [
                                {
                                    name: "type",
                                    label: "type",
                                    type: "input-text",
                                    options: [
                                        {
                                            label: "图片",
                                            value: "image"
                                        },
                                        {
                                            label: "语音",
                                            value: "voice"
                                        },
                                        {
                                            label: "视频",
                                            value: "video"
                                        },
                                        {
                                            label: "缩略图",
                                            value: "thumb"
                                        }
                                    ]
                                },
                                {
                                    name: "media",
                                    label: "media",
                                    type: "input-text",
                                }
                            ],
                        },
                    },
                }, {
                    label: "新增图文素材",
                    type: "button",
                    actionType: "dialog",
                    dialog: {
                        title: "新增图文素材",
                        size: "lg",
                        body: {
                            type: "form",
                            api: "post:hostml/graphic/media?media=${media}",
                            body: [
                                {
                                    name: "media",
                                    label: "media",
                                    type: "input-text",
                                }
                            ],
                        },
                    },
                }, {
                    label: "新增永久素材",
                    type: "button",
                    actionType: "dialog",
                    dialog: {
                        title: "新增永久素材",
                        size: "lg",
                        body: {
                            type: "form",
                            api: "post:hostml/permanent/media?type=${type}&media=${media}",
                            body: [
                                {
                                    name: "type",
                                    label: "type",
                                    type: "input-text",
                                    options: [
                                        {
                                            label: "图片",
                                            value: "image"
                                        },
                                        {
                                            label: "语音",
                                            value: "voice"
                                        },
                                        {
                                            label: "视频",
                                            value: "video"
                                        },
                                        {
                                            label: "缩略图",
                                            value: "thumb"
                                        }
                                    ]
                                },
                                {
                                    name: "media",
                                    label: "media",
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
                        name: "mediaId",
                        label: "mediaId",
                        placeholder: "通过mediaId进行搜索",
                        clearable: true,
                    }, {
                        type: "input-text",
                        name: "mediaModel",
                        label: "mediaModel",
                        placeholder: "通过mediaModel进行搜索",
                        clearable: true,
                        options: [
                            {
                                label: "临时",
                                value: "TEMPORARY"
                            },{
                                label: "图文永久",
                                value: "GRAPHIC_PIC"
                            },
                            {
                                label: "永久",
                                value: "PERMANENT"
                            }
                        ]
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
