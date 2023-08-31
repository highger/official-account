package com.mgy.official.account.service.res;

import lombok.Data;

/**
 * @author mgy
 * @date 2023/8/29
 */
@Data
public class WxMediaRes {
   // {"type":"image","media_id":"kt3bvUfqKCua19Qus9H3Oz1UMRhjm5_CH3P7zarvPavrn14wKzCmMFQpReNvgOTZ","created_at":1693287549,"item":[]}
   private String type;
   private String media_id;
   private Long created_at;
}
