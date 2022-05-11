/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package rating.model;

/**
 *
 * @author nour
 */
public class Rating {
    private String msisdn;                                
    private Integer rateplan_id;                      
    private Double voice_onnet = 0.0;                 
    private Double voice_crossnet = 0.0;
    private Double data = 0.0;
    private Integer sms_onnet = 0;
    private Integer sms_crossnet =0;
    
    public Rating (){}

    public Rating(String msisdn, Integer rateplan_id, Double voice_onnet, Double voice_crossnet, Double data, Integer sms_onnet, Integer sms_crossnet) {
        this.msisdn = msisdn;
        this.rateplan_id = rateplan_id;
        this.voice_onnet = voice_onnet;
        this.voice_crossnet = voice_crossnet;
        this.data = data;
        this.sms_onnet = sms_onnet;
        this.sms_crossnet = sms_crossnet;
    }

    public String getMsisdn() {
        return msisdn;
    }

    public void setMsisdn(String msisdn) {
        this.msisdn = msisdn;
    }

    public Integer getRateplan_id() {
        return rateplan_id;
    }

    public void setRateplan_id(Integer rateplan_id) {
        this.rateplan_id = rateplan_id;
    }

    public Double getVoice_onnet() {
        return voice_onnet;
    }

    public void setVoice_onnet(Double voice_onnet) {
        this.voice_onnet = voice_onnet;
    }

    public Double getVoice_crossnet() {
        return voice_crossnet;
    }

    public void setVoice_crossnet(Double voice_crossnet) {
        this.voice_crossnet = voice_crossnet;
    }

    public Double getData() {
        return data;
    }

    public void setData(Double data) {
        this.data = data;
    }

    public Integer getSms_onnet() {
        return sms_onnet;
    }

    public void setSms_onnet(Integer sms_onnet) {
        this.sms_onnet = sms_onnet;
    }

    public Integer getSms_crossnet() {
        return sms_crossnet;
    }

    public void setSms_crossnet(Integer sms_crossnet) {
        this.sms_crossnet = sms_crossnet;
    }
       
}
