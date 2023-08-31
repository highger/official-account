let openMicroAppPage = {
    "title": "开通微应用",
    "body": [
        {
            "type": "form",
            "title": "开通微应用",
            "body": [
                {
                    "label": "项目code",
                    "type": "input-text",
                    "name": "projectCode",
                    "required": true,
                    "description": "iot 云平台项目的唯一标识projectCode"
                },
                {
                    "type": "list-select",
                    "name": "select",
                    "multiple":true,
                    "label": "待开通微应用",
                    "clearable": true,
                    "source":"https://micro-oem-saas.wgine-daily.com:7799/micro/apps/newest",
                    "options": [
                      {
                        "label": "Option A",
                        "value": "a"
                      },
                      {
                        "label": "Option B",
                        "value": "b"
                      }
                    ]
                  }
            ],
            "api": {
                "method": "post",
                "url": "https://micro-oem-saas.wgine-daily.com:7799/oem/saas/app/open",
                "responseData": null
            },
            "autoFocus": true,
            "affixFooter": false
        },
    ]
}