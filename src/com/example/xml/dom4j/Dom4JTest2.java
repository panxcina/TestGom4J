package com.example.xml.dom4j;

import java.io.File;
import java.util.Iterator;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.DOMReader;
import org.dom4j.io.SAXReader;

/*
 * dom4j���ѧϰ�� ��ȡ������xml
 */
public class Dom4JTest2
{
    public static void main(String[] args) throws Exception
    {
    	
        SAXReader saxReader = new SAXReader();

        Document document = saxReader.read(new File("students.xml"));

        // ��ȡ��Ԫ��
        Element root = document.getRootElement();
        System.out.println("Root: " + root.getName());

        // ��ȡ������Ԫ��
        List<Element> childList = root.elements();
        System.out.println("total child count: " + childList.size());
        
        // ��ȡ�ض����Ƶ���Ԫ��
        List<Element> childList2 = root.elements("hello");
        System.out.println("hello child: " + childList2.size());

        // ��ȡ����Ϊָ�����Ƶĵ�һ����Ԫ��
        Element firstWorldElement = root.element("world");
        // ���������
        System.out.println("first World Attr: "
                + firstWorldElement.attribute(0).getName() + "="
                + firstWorldElement.attributeValue("name"));

        System.out.println("�������-----------------------");
        // �������
        for ( Iterator iter = root.elementIterator(); iter.hasNext(); )
        {
            Element e = (Element) iter.next();
            System.out.println(e.attributeValue("name"));

        }

        System.out.println("��DOMReader-----------------------");
        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
        DocumentBuilder db = dbf.newDocumentBuilder();
        // ע��Ҫ����������
        org.w3c.dom.Document document2 = db.parse(new File("students.xml "));

        DOMReader domReader = new DOMReader();

        // ��JAXP��Documentת��Ϊdom4j��Document
        Document document3 = domReader.read(document2);

        Element rootElement = document3.getRootElement();

        System.out.println("Root: " + rootElement.getName());
        
        
    }

}