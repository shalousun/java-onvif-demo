package com.shalousun.onvif;

import org.apache.cxf.ws.discovery.WSDiscoveryClient;
import org.apache.cxf.ws.discovery.wsdl.ProbeMatchType;
import org.apache.cxf.ws.discovery.wsdl.ProbeMatchesType;
import org.apache.cxf.ws.discovery.wsdl.ProbeType;

import javax.xml.namespace.QName;
import java.util.List;

/**
 * @author yu 2020/8/4.
 */
public class CxfOnvif {

    public static void main(String[] args) {
        WSDiscoveryClient client = new WSDiscoveryClient();
        client.setVersion10();
        client.setDefaultProbeTimeout(5000); // timeout 5s
        ProbeType probeType = new ProbeType();
        probeType.getTypes().add(new QName("tds:Device"));
        probeType.getTypes().add(new QName("dn:Network Video Transmitter"));//
        System.out.println("Probe:" + client.getAddress());
        ProbeMatchesType probeMatchesType = client.probe(probeType);
        //探索设备
        List<ProbeMatchType> probeMatchTypes = probeMatchesType.getProbeMatch();
        for (ProbeMatchType type : probeMatchTypes) {
            System.out.println(type.getXAddrs());
        }

    }
}
