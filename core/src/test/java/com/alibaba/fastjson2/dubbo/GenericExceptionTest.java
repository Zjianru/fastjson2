package com.alibaba.fastjson2.dubbo;

import com.alibaba.fastjson2.JSON;
import com.alibaba.fastjson2.JSONB;
import com.alibaba.fastjson2.JSONReader;
import com.alibaba.fastjson2.JSONWriter;
import com.alibaba.fastjson2.util.JSONBDump;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertNotNull;

public class GenericExceptionTest {
    @Test
    public void test() {
        GenericException exception = new GenericException("", "");
        byte[] jsonbBytes = JSONB.toBytes(
                exception,
                JSONWriter.Feature.WriteClassName,
                JSONWriter.Feature.FieldBased,
                JSONWriter.Feature.ReferenceDetection,
                JSONWriter.Feature.WriteNulls,
                JSONWriter.Feature.NotWriteDefaultValue,
                JSONWriter.Feature.NotWriteHashMapArrayListClassName,
                JSONWriter.Feature.WriteNameAsSymbol
        );
        JSONBDump.dump(jsonbBytes);

        GenericException exception1 = (GenericException) JSONB.parseObject(
                jsonbBytes,
                Object.class, JSONReader.Feature.SupportAutoType,
                JSONReader.Feature.UseDefaultConstructorAsPossible,
                JSONReader.Feature.UseNativeObject,
                JSONReader.Feature.FieldBased
        );
    }

    @Test
    public void test1() {
        String str = "\"knVjb20uYWxpYmFiYS5mYXN0anNvbjIuZHViYm8uR2VuZXJpY0V4Y2VwdGlvbgCmf1dleGNlcHRpb25DbGFzcwFJf1lleGNlcHRpb25NZXNzYWdlAkl/XWdlbmVyaWNFeGNlcHRpb25JbmZvA6Z/UGV4Q2xhc3MESX9OZXhNc2cFSX9MbXNnBkl/U3N0YWNrVHJhY2UHpDhHpn9RZmlsZU5hbWUIYkdlbmVyaWNFeGNlcHRpb25UZXN0LmphdmF/U2xpbmVOdW1iZXIJDX9SY2xhc3NOYW1lCnk4MGNvbS5hbGliYWJhLmZhc3Rqc29uMi5kdWJiby5HZW5lcmljRXhjZXB0aW9uVGVzdH9TbWV0aG9kTmFtZQtNdGVzdKWmfwhmTmF0aXZlTWV0aG9kQWNjZXNzb3JJbXBsLmphdmF/Cf5/Cm1zdW4ucmVmbGVjdC5OYXRpdmVNZXRob2RBY2Nlc3NvckltcGx/C1BpbnZva2UwpaZ/CGZOYXRpdmVNZXRob2RBY2Nlc3NvckltcGwuamF2YX8JOD5/Cm1zdW4ucmVmbGVjdC5OYXRpdmVNZXRob2RBY2Nlc3NvckltcGx/C09pbnZva2Wlpn8IakRlbGVnYXRpbmdNZXRob2RBY2Nlc3NvckltcGwuamF2YX8JK38KcXN1bi5yZWZsZWN0LkRlbGVnYXRpbmdNZXRob2RBY2Nlc3NvckltcGx/C09pbnZva2Wlpn8IVE1ldGhvZC5qYXZhfwk58n8KYWphdmEubGFuZy5yZWZsZWN0Lk1ldGhvZH8LT2ludm9rZaWmfwhdUmVmbGVjdGlvblV0aWxzLmphdmF/CTrXfwp4b3JnLmp1bml0LnBsYXRmb3JtLmNvbW1vbnMudXRpbC5SZWZsZWN0aW9uVXRpbHN/C1VpbnZva2VNZXRob2Slpn8IXk1ldGhvZEludm9jYXRpb24uamF2YX8JODx/Cnk4M29yZy5qdW5pdC5qdXBpdGVyLmVuZ2luZS5leGVjdXRpb24uTWV0aG9kSW52b2NhdGlvbn8LUHByb2NlZWSlpn8IaEludm9jYXRpb25JbnRlcmNlcHRvckNoYWluLmphdmF/CTiDfwp5OFJvcmcuanVuaXQuanVwaXRlci5lbmdpbmUuZXhlY3V0aW9uLkludm9jYXRpb25JbnRlcmNlcHRvckNoYWluJFZhbGlkYXRpbmdJbnZvY2F0aW9ufwtQcHJvY2VlZKWmfwheVGltZW91dEV4dGVuc2lvbi5qYXZhfwk4nH8KeTgzb3JnLmp1bml0Lmp1cGl0ZXIuZW5naW5lLmV4dGVuc2lvbi5UaW1lb3V0RXh0ZW5zaW9ufwtSaW50ZXJjZXB0paZ/CF5UaW1lb3V0RXh0ZW5zaW9uLmphdmF/CTiTfwp5ODNvcmcuanVuaXQuanVwaXRlci5lbmdpbmUuZXh0ZW5zaW9uLlRpbWVvdXRFeHRlbnNpb25/C2BpbnRlcmNlcHRUZXN0YWJsZU1ldGhvZKWmfwheVGltZW91dEV4dGVuc2lvbi5qYXZhfwk4Vn8KeTgzb3JnLmp1bml0Lmp1cGl0ZXIuZW5naW5lLmV4dGVuc2lvbi5UaW1lb3V0RXh0ZW5zaW9ufwtcaW50ZXJjZXB0VGVzdE1ldGhvZKWmfwhrSW50ZXJjZXB0aW5nRXhlY3V0YWJsZUludm9rZXIuamF2YX8JOGd/Cnk4Wm9yZy5qdW5pdC5qdXBpdGVyLmVuZ2luZS5leGVjdXRpb24uSW50ZXJjZXB0aW5nRXhlY3V0YWJsZUludm9rZXIkUmVmbGVjdGl2ZUludGVyY2VwdG9yQ2FsbH8LXmxhbWJkYSRvZlZvaWRNZXRob2QkMKWmfwhrSW50ZXJjZXB0aW5nRXhlY3V0YWJsZUludm9rZXIuamF2YX8JOF1/Cnk4QG9yZy5qdW5pdC5qdXBpdGVyLmVuZ2luZS5leGVjdXRpb24uSW50ZXJjZXB0aW5nRXhlY3V0YWJsZUludm9rZXJ/C1hsYW1iZGEkaW52b2tlJDClpn8IaEludm9jYXRpb25JbnRlcmNlcHRvckNoYWluLmphdmF/CThqfwp5OFNvcmcuanVuaXQuanVwaXRlci5lbmdpbmUuZXhlY3V0aW9uLkludm9jYXRpb25JbnRlcmNlcHRvckNoYWluJEludGVyY2VwdGVkSW52b2NhdGlvbn8LUHByb2NlZWSlpn8IaEludm9jYXRpb25JbnRlcmNlcHRvckNoYWluLmphdmF/CThAfwp5OD1vcmcuanVuaXQuanVwaXRlci5lbmdpbmUuZXhlY3V0aW9uLkludm9jYXRpb25JbnRlcmNlcHRvckNoYWlufwtQcHJvY2VlZKWmfwhoSW52b2NhdGlvbkludGVyY2VwdG9yQ2hhaW4uamF2YX8JLX8KeTg9b3JnLmp1bml0Lmp1cGl0ZXIuZW5naW5lLmV4ZWN1dGlvbi5JbnZvY2F0aW9uSW50ZXJjZXB0b3JDaGFpbn8LV2NoYWluQW5kSW52b2tlpaZ/CGhJbnZvY2F0aW9uSW50ZXJjZXB0b3JDaGFpbi5qYXZhfwklfwp5OD1vcmcuanVuaXQuanVwaXRlci5lbmdpbmUuZXhlY3V0aW9uLkludm9jYXRpb25JbnRlcmNlcHRvckNoYWlufwtPaW52b2tlpaZ/CGtJbnRlcmNlcHRpbmdFeGVjdXRhYmxlSW52b2tlci5qYXZhfwk4XH8KeThAb3JnLmp1bml0Lmp1cGl0ZXIuZW5naW5lLmV4ZWN1dGlvbi5JbnRlcmNlcHRpbmdFeGVjdXRhYmxlSW52b2tlcn8LT2ludm9rZaWmfwhrSW50ZXJjZXB0aW5nRXhlY3V0YWJsZUludm9rZXIuamF2YX8JOFZ/Cnk4QG9yZy5qdW5pdC5qdXBpdGVyLmVuZ2luZS5leGVjdXRpb24uSW50ZXJjZXB0aW5nRXhlY3V0YWJsZUludm9rZXJ/C09pbnZva2Wlpn8IZlRlc3RNZXRob2RUZXN0RGVzY3JpcHRvci5qYXZhfwk42X8KeTg8b3JnLmp1bml0Lmp1cGl0ZXIuZW5naW5lLmRlc2NyaXB0b3IuVGVzdE1ldGhvZFRlc3REZXNjcmlwdG9yfwtibGFtYmRhJGludm9rZVRlc3RNZXRob2QkN6WmfwhgVGhyb3dhYmxlQ29sbGVjdG9yLmphdmF/CThJfwp5OEFvcmcuanVuaXQucGxhdGZvcm0uZW5naW5lLnN1cHBvcnQuaGllcmFyY2hpY2FsLlRocm93YWJsZUNvbGxlY3Rvcn8LUGV4ZWN1dGWlpn8IZlRlc3RNZXRob2RUZXN0RGVzY3JpcHRvci5qYXZhfwk41X8KeTg8b3JnLmp1bml0Lmp1cGl0ZXIuZW5naW5lLmRlc2NyaXB0b3IuVGVzdE1ldGhvZFRlc3REZXNjcmlwdG9yfwtZaW52b2tlVGVzdE1ldGhvZKWmfwhmVGVzdE1ldGhvZFRlc3REZXNjcmlwdG9yLmphdmF/CTiKfwp5ODxvcmcuanVuaXQuanVwaXRlci5lbmdpbmUuZGVzY3JpcHRvci5UZXN0TWV0aG9kVGVzdERlc2NyaXB0b3J/C1BleGVjdXRlpaZ/CGZUZXN0TWV0aG9kVGVzdERlc2NyaXB0b3IuamF2YX8JOER/Cnk4PG9yZy5qdW5pdC5qdXBpdGVyLmVuZ2luZS5kZXNjcmlwdG9yLlRlc3RNZXRob2RUZXN0RGVzY3JpcHRvcn8LUGV4ZWN1dGWlpn8IWk5vZGVUZXN0VGFzay5qYXZhfwk4l38KeTg7b3JnLmp1bml0LnBsYXRmb3JtLmVuZ2luZS5zdXBwb3J0LmhpZXJhcmNoaWNhbC5Ob2RlVGVzdFRhc2t/C2RsYW1iZGEkZXhlY3V0ZVJlY3Vyc2l2ZWx5JDalpn8IYFRocm93YWJsZUNvbGxlY3Rvci5qYXZhfwk4SX8KeThBb3JnLmp1bml0LnBsYXRmb3JtLmVuZ2luZS5zdXBwb3J0LmhpZXJhcmNoaWNhbC5UaHJvd2FibGVDb2xsZWN0b3J/C1BleGVjdXRlpaZ/CFpOb2RlVGVzdFRhc2suamF2YX8JOI1/Cnk4O29yZy5qdW5pdC5wbGF0Zm9ybS5lbmdpbmUuc3VwcG9ydC5oaWVyYXJjaGljYWwuTm9kZVRlc3RUYXNrfwtkbGFtYmRhJGV4ZWN1dGVSZWN1cnNpdmVseSQ4paZ/CFJOb2RlLmphdmF/CTiJfwp5ODNvcmcuanVuaXQucGxhdGZvcm0uZW5naW5lLnN1cHBvcnQuaGllcmFyY2hpY2FsLk5vZGV/C09hcm91bmSlpn8IWk5vZGVUZXN0VGFzay5qYXZhfwk4i38KeTg7b3JnLmp1bml0LnBsYXRmb3JtLmVuZ2luZS5zdXBwb3J0LmhpZXJhcmNoaWNhbC5Ob2RlVGVzdFRhc2t/C2RsYW1iZGEkZXhlY3V0ZVJlY3Vyc2l2ZWx5JDmlpn8IYFRocm93YWJsZUNvbGxlY3Rvci5qYXZhfwk4SX8KeThBb3JnLmp1bml0LnBsYXRmb3JtLmVuZ2luZS5zdXBwb3J0LmhpZXJhcmNoaWNhbC5UaHJvd2FibGVDb2xsZWN0b3J/C1BleGVjdXRlpaZ/CFpOb2RlVGVzdFRhc2suamF2YX8JOIp/Cnk4O29yZy5qdW5pdC5wbGF0Zm9ybS5lbmdpbmUuc3VwcG9ydC5oaWVyYXJjaGljYWwuTm9kZVRlc3RUYXNrfwtbZXhlY3V0ZVJlY3Vyc2l2ZWx5paZ/CFpOb2RlVGVzdFRhc2suamF2YX8JOF9/Cnk4O29yZy5qdW5pdC5wbGF0Zm9ybS5lbmdpbmUuc3VwcG9ydC5oaWVyYXJjaGljYWwuTm9kZVRlc3RUYXNrfwtQZXhlY3V0ZaWmfwhXQXJyYXlMaXN0LmphdmF/CTzrfwpcamF2YS51dGlsLkFycmF5TGlzdH8LUGZvckVhY2ilpn8Id1NhbWVUaHJlYWRIaWVyYXJjaGljYWxUZXN0RXhlY3V0b3JTZXJ2aWNlLmphdmF/CSl/Cnk4WG9yZy5qdW5pdC5wbGF0Zm9ybS5lbmdpbmUuc3VwcG9ydC5oaWVyYXJjaGljYWwuU2FtZVRocmVhZEhpZXJhcmNoaWNhbFRlc3RFeGVjdXRvclNlcnZpY2V/C1JpbnZva2VBbGylpn8IWk5vZGVUZXN0VGFzay5qYXZhfwk4m38KeTg7b3JnLmp1bml0LnBsYXRmb3JtLmVuZ2luZS5zdXBwb3J0LmhpZXJhcmNoaWNhbC5Ob2RlVGVzdFRhc2t/C2RsYW1iZGEkZXhlY3V0ZVJlY3Vyc2l2ZWx5JDalpn8IYFRocm93YWJsZUNvbGxlY3Rvci5qYXZhfwk4SX8KeThBb3JnLmp1bml0LnBsYXRmb3JtLmVuZ2luZS5zdXBwb3J0LmhpZXJhcmNoaWNhbC5UaHJvd2FibGVDb2xsZWN0b3J/C1BleGVjdXRlpaZ/CFpOb2RlVGVzdFRhc2suamF2YX8JOI1/Cnk4O29yZy5qdW5pdC5wbGF0Zm9ybS5lbmdpbmUuc3VwcG9ydC5oaWVyYXJjaGljYWwuTm9kZVRlc3RUYXNrfwtkbGFtYmRhJGV4ZWN1dGVSZWN1cnNpdmVseSQ4paZ/CFJOb2RlLmphdmF/CTiJfwp5ODNvcmcuanVuaXQucGxhdGZvcm0uZW5naW5lLnN1cHBvcnQuaGllcmFyY2hpY2FsLk5vZGV/C09hcm91bmSlpn8IWk5vZGVUZXN0VGFzay5qYXZhfwk4i38KeTg7b3JnLmp1bml0LnBsYXRmb3JtLmVuZ2luZS5zdXBwb3J0LmhpZXJhcmNoaWNhbC5Ob2RlVGVzdFRhc2t/C2RsYW1iZGEkZXhlY3V0ZVJlY3Vyc2l2ZWx5JDmlpn8IYFRocm93YWJsZUNvbGxlY3Rvci5qYXZhfwk4SX8KeThBb3JnLmp1bml0LnBsYXRmb3JtLmVuZ2luZS5zdXBwb3J0LmhpZXJhcmNoaWNhbC5UaHJvd2FibGVDb2xsZWN0b3J/C1BleGVjdXRlpaZ/CFpOb2RlVGVzdFRhc2suamF2YX8JOIp/Cnk4O29yZy5qdW5pdC5wbGF0Zm9ybS5lbmdpbmUuc3VwcG9ydC5oaWVyYXJjaGljYWwuTm9kZVRlc3RUYXNrfwtbZXhlY3V0ZVJlY3Vyc2l2ZWx5paZ/CFpOb2RlVGVzdFRhc2suamF2YX8JOF9/Cnk4O29yZy5qdW5pdC5wbGF0Zm9ybS5lbmdpbmUuc3VwcG9ydC5oaWVyYXJjaGljYWwuTm9kZVRlc3RUYXNrfwtQZXhlY3V0ZaWmfwhXQXJyYXlMaXN0LmphdmF/CTzrfwpcamF2YS51dGlsLkFycmF5TGlzdH8LUGZvckVhY2ilpn8Id1NhbWVUaHJlYWRIaWVyYXJjaGljYWxUZXN0RXhlY3V0b3JTZXJ2aWNlLmphdmF/CSl/Cnk4WG9yZy5qdW5pdC5wbGF0Zm9ybS5lbmdpbmUuc3VwcG9ydC5oaWVyYXJjaGljYWwuU2FtZVRocmVhZEhpZXJhcmNoaWNhbFRlc3RFeGVjdXRvclNlcnZpY2V/C1JpbnZva2VBbGylpn8IWk5vZGVUZXN0VGFzay5qYXZhfwk4m38KeTg7b3JnLmp1bml0LnBsYXRmb3JtLmVuZ2luZS5zdXBwb3J0LmhpZXJhcmNoaWNhbC5Ob2RlVGVzdFRhc2t/C2RsYW1iZGEkZXhlY3V0ZVJlY3Vyc2l2ZWx5JDalpn8IYFRocm93YWJsZUNvbGxlY3Rvci5qYXZhfwk4SX8KeThBb3JnLmp1bml0LnBsYXRmb3JtLmVuZ2luZS5zdXBwb3J0LmhpZXJhcmNoaWNhbC5UaHJvd2FibGVDb2xsZWN0b3J/C1BleGVjdXRlpaZ/CFpOb2RlVGVzdFRhc2suamF2YX8JOI1/Cnk4O29yZy5qdW5pdC5wbGF0Zm9ybS5lbmdpbmUuc3VwcG9ydC5oaWVyYXJjaGljYWwuTm9kZVRlc3RUYXNrfwtkbGFtYmRhJGV4ZWN1dGVSZWN1cnNpdmVseSQ4paZ/CFJOb2RlLmphdmF/CTiJfwp5ODNvcmcuanVuaXQucGxhdGZvcm0uZW5naW5lLnN1cHBvcnQuaGllcmFyY2hpY2FsLk5vZGV/C09hcm91bmSlpn8IWk5vZGVUZXN0VGFzay5qYXZhfwk4i38KeTg7b3JnLmp1bml0LnBsYXRmb3JtLmVuZ2luZS5zdXBwb3J0LmhpZXJhcmNoaWNhbC5Ob2RlVGVzdFRhc2t/C2RsYW1iZGEkZXhlY3V0ZVJlY3Vyc2l2ZWx5JDmlpn8IYFRocm93YWJsZUNvbGxlY3Rvci5qYXZhfwk4SX8KeThBb3JnLmp1bml0LnBsYXRmb3JtLmVuZ2luZS5zdXBwb3J0LmhpZXJhcmNoaWNhbC5UaHJvd2FibGVDb2xsZWN0b3J/C1BleGVjdXRlpaZ/CFpOb2RlVGVzdFRhc2suamF2YX8JOIp/Cnk4O29yZy5qdW5pdC5wbGF0Zm9ybS5lbmdpbmUuc3VwcG9ydC5oaWVyYXJjaGljYWwuTm9kZVRlc3RUYXNrfwtbZXhlY3V0ZVJlY3Vyc2l2ZWx5paZ/CFpOb2RlVGVzdFRhc2suamF2YX8JOF9/Cnk4O29yZy5qdW5pdC5wbGF0Zm9ybS5lbmdpbmUuc3VwcG9ydC5oaWVyYXJjaGljYWwuTm9kZVRlc3RUYXNrfwtQZXhlY3V0ZaWmfwh3U2FtZVRocmVhZEhpZXJhcmNoaWNhbFRlc3RFeGVjdXRvclNlcnZpY2UuamF2YX8JI38KeThYb3JnLmp1bml0LnBsYXRmb3JtLmVuZ2luZS5zdXBwb3J0LmhpZXJhcmNoaWNhbC5TYW1lVGhyZWFkSGllcmFyY2hpY2FsVGVzdEV4ZWN1dG9yU2VydmljZX8LT3N1Ym1pdKWmfwhmSGllcmFyY2hpY2FsVGVzdEV4ZWN1dG9yLmphdmF/CTg5fwp5OEdvcmcuanVuaXQucGxhdGZvcm0uZW5naW5lLnN1cHBvcnQuaGllcmFyY2hpY2FsLkhpZXJhcmNoaWNhbFRlc3RFeGVjdXRvcn8LUGV4ZWN1dGWlpn8IZEhpZXJhcmNoaWNhbFRlc3RFbmdpbmUuamF2YX8JODZ/Cnk4RW9yZy5qdW5pdC5wbGF0Zm9ybS5lbmdpbmUuc3VwcG9ydC5oaWVyYXJjaGljYWwuSGllcmFyY2hpY2FsVGVzdEVuZ2luZX8LUGV4ZWN1dGWlpn8IaUVuZ2luZUV4ZWN1dGlvbk9yY2hlc3RyYXRvci5qYXZhfwk4k38KeTg8b3JnLmp1bml0LnBsYXRmb3JtLmxhdW5jaGVyLmNvcmUuRW5naW5lRXhlY3V0aW9uT3JjaGVzdHJhdG9yfwtQZXhlY3V0ZaWmfwhpRW5naW5lRXhlY3V0aW9uT3JjaGVzdHJhdG9yLmphdmF/CTh/fwp5ODxvcmcuanVuaXQucGxhdGZvcm0ubGF1bmNoZXIuY29yZS5FbmdpbmVFeGVjdXRpb25PcmNoZXN0cmF0b3J/C1BleGVjdXRlpaZ/CGlFbmdpbmVFeGVjdXRpb25PcmNoZXN0cmF0b3IuamF2YX8JOFp/Cnk4PG9yZy5qdW5pdC5wbGF0Zm9ybS5sYXVuY2hlci5jb3JlLkVuZ2luZUV4ZWN1dGlvbk9yY2hlc3RyYXRvcn8LUGV4ZWN1dGWlpn8IaUVuZ2luZUV4ZWN1dGlvbk9yY2hlc3RyYXRvci5qYXZhfwk4N38KeTg8b3JnLmp1bml0LnBsYXRmb3JtLmxhdW5jaGVyLmNvcmUuRW5naW5lRXhlY3V0aW9uT3JjaGVzdHJhdG9yfwtZbGFtYmRhJGV4ZWN1dGUkMKWmfwhpRW5naW5lRXhlY3V0aW9uT3JjaGVzdHJhdG9yLmphdmF/CThmfwp5ODxvcmcuanVuaXQucGxhdGZvcm0ubGF1bmNoZXIuY29yZS5FbmdpbmVFeGVjdXRpb25PcmNoZXN0cmF0b3J/C193aXRoSW50ZXJjZXB0ZWRTdHJlYW1zpaZ/CGlFbmdpbmVFeGVjdXRpb25PcmNoZXN0cmF0b3IuamF2YX8JODZ/Cnk4PG9yZy5qdW5pdC5wbGF0Zm9ybS5sYXVuY2hlci5jb3JlLkVuZ2luZUV4ZWN1dGlvbk9yY2hlc3RyYXRvcn8LUGV4ZWN1dGWlpn8IXURlZmF1bHRMYXVuY2hlci5qYXZhfwk4cn8KeTgwb3JnLmp1bml0LnBsYXRmb3JtLmxhdW5jaGVyLmNvcmUuRGVmYXVsdExhdW5jaGVyfwtQZXhlY3V0ZaWmfwhdRGVmYXVsdExhdW5jaGVyLmphdmF/CThWfwp5ODBvcmcuanVuaXQucGxhdGZvcm0ubGF1bmNoZXIuY29yZS5EZWZhdWx0TGF1bmNoZXJ/C1BleGVjdXRlpaZ/CGREZWZhdWx0TGF1bmNoZXJTZXNzaW9uLmphdmF/CThWfwp5OEpvcmcuanVuaXQucGxhdGZvcm0ubGF1bmNoZXIuY29yZS5EZWZhdWx0TGF1bmNoZXJTZXNzaW9uJERlbGVnYXRpbmdMYXVuY2hlcn8LUGV4ZWN1dGWlpn8IZ1Nlc3Npb25QZXJSZXF1ZXN0TGF1bmNoZXIuamF2YX8JODV/Cnk4Om9yZy5qdW5pdC5wbGF0Zm9ybS5sYXVuY2hlci5jb3JlLlNlc3Npb25QZXJSZXF1ZXN0TGF1bmNoZXJ/C1BleGVjdXRlpaZ/CGJKVW5pdDVJZGVhVGVzdFJ1bm5lci5qYXZhfwk4OX8KcWNvbS5pbnRlbGxpai5qdW5pdDUuSlVuaXQ1SWRlYVRlc3RSdW5uZXJ/C1xzdGFydFJ1bm5lcldpdGhBcmdzpaZ/CFxJZGVhVGVzdFJ1bm5lci5qYXZhfwkmfwp4Y29tLmludGVsbGlqLnJ0Lmp1bml0LklkZWFUZXN0UnVubmVyJFJlcGVhdGVyJDF/C1BleGVjdXRlpaZ/CFtUZXN0c1JlcGVhdGVyLmphdmF/CQt/CnZjb20uaW50ZWxsaWoucnQuZXhlY3V0aW9uLmp1bml0LlRlc3RzUmVwZWF0ZXJ/C09yZXBlYXSlpn8IXElkZWFUZXN0UnVubmVyLmphdmF/CSN/CnZjb20uaW50ZWxsaWoucnQuanVuaXQuSWRlYVRlc3RSdW5uZXIkUmVwZWF0ZXJ/C1xzdGFydFJ1bm5lcldpdGhBcmdzpaZ/CFpKVW5pdFN0YXJ0ZXIuamF2YX8JOOt/Cmtjb20uaW50ZWxsaWoucnQuanVuaXQuSlVuaXRTdGFydGVyfwtfcHJlcGFyZVN0cmVhbXNBbmRTdGFydKWmfwhaSlVuaXRTdGFydGVyLmphdmF/CTg2fwprY29tLmludGVsbGlqLnJ0Lmp1bml0LkpVbml0U3RhcnRlcn8LTW1haW6lpX9QbWVzc2FnZQxreyJleENsYXNzIjoiIiwiZXhNc2ciOiIiLCJtc2ciOiIifX8HpDhHk20kLmdlbmVyaWNFeGNlcHRpb25JbmZvLnN0YWNrVHJhY2VbMF2TbSQuZ2VuZXJpY0V4Y2VwdGlvbkluZm8uc3RhY2tUcmFjZVsxXZNtJC5nZW5lcmljRXhjZXB0aW9uSW5mby5zdGFja1RyYWNlWzJdk20kLmdlbmVyaWNFeGNlcHRpb25JbmZvLnN0YWNrVHJhY2VbM12TbSQuZ2VuZXJpY0V4Y2VwdGlvbkluZm8uc3RhY2tUcmFjZVs0XZNtJC5nZW5lcmljRXhjZXB0aW9uSW5mby5zdGFja1RyYWNlWzVdk20kLmdlbmVyaWNFeGNlcHRpb25JbmZvLnN0YWNrVHJhY2VbNl2TbSQuZ2VuZXJpY0V4Y2VwdGlvbkluZm8uc3RhY2tUcmFjZVs3XZNtJC5nZW5lcmljRXhjZXB0aW9uSW5mby5zdGFja1RyYWNlWzhdk20kLmdlbmVyaWNFeGNlcHRpb25JbmZvLnN0YWNrVHJhY2VbOV2TbiQuZ2VuZXJpY0V4Y2VwdGlvbkluZm8uc3RhY2tUcmFjZVsxMF2TbiQuZ2VuZXJpY0V4Y2VwdGlvbkluZm8uc3RhY2tUcmFjZVsxMV2TbiQuZ2VuZXJpY0V4Y2VwdGlvbkluZm8uc3RhY2tUcmFjZVsxMl2TbiQuZ2VuZXJpY0V4Y2VwdGlvbkluZm8uc3RhY2tUcmFjZVsxM12TbiQuZ2VuZXJpY0V4Y2VwdGlvbkluZm8uc3RhY2tUcmFjZVsxNF2TbiQuZ2VuZXJpY0V4Y2VwdGlvbkluZm8uc3RhY2tUcmFjZVsxNV2TbiQuZ2VuZXJpY0V4Y2VwdGlvbkluZm8uc3RhY2tUcmFjZVsxNl2TbiQuZ2VuZXJpY0V4Y2VwdGlvbkluZm8uc3RhY2tUcmFjZVsxN12TbiQuZ2VuZXJpY0V4Y2VwdGlvbkluZm8uc3RhY2tUcmFjZVsxOF2TbiQuZ2VuZXJpY0V4Y2VwdGlvbkluZm8uc3RhY2tUcmFjZVsxOV2TbiQuZ2VuZXJpY0V4Y2VwdGlvbkluZm8uc3RhY2tUcmFjZVsyMF2TbiQuZ2VuZXJpY0V4Y2VwdGlvbkluZm8uc3RhY2tUcmFjZVsyMV2TbiQuZ2VuZXJpY0V4Y2VwdGlvbkluZm8uc3RhY2tUcmFjZVsyMl2TbiQuZ2VuZXJpY0V4Y2VwdGlvbkluZm8uc3RhY2tUcmFjZVsyM12TbiQuZ2VuZXJpY0V4Y2VwdGlvbkluZm8uc3RhY2tUcmFjZVsyNF2TbiQuZ2VuZXJpY0V4Y2VwdGlvbkluZm8uc3RhY2tUcmFjZVsyNV2TbiQuZ2VuZXJpY0V4Y2VwdGlvbkluZm8uc3RhY2tUcmFjZVsyNl2TbiQuZ2VuZXJpY0V4Y2VwdGlvbkluZm8uc3RhY2tUcmFjZVsyN12TbiQuZ2VuZXJpY0V4Y2VwdGlvbkluZm8uc3RhY2tUcmFjZVsyOF2TbiQuZ2VuZXJpY0V4Y2VwdGlvbkluZm8uc3RhY2tUcmFjZVsyOV2TbiQuZ2VuZXJpY0V4Y2VwdGlvbkluZm8uc3RhY2tUcmFjZVszMF2TbiQuZ2VuZXJpY0V4Y2VwdGlvbkluZm8uc3RhY2tUcmFjZVszMV2TbiQuZ2VuZXJpY0V4Y2VwdGlvbkluZm8uc3RhY2tUcmFjZVszMl2TbiQuZ2VuZXJpY0V4Y2VwdGlvbkluZm8uc3RhY2tUcmFjZVszM12TbiQuZ2VuZXJpY0V4Y2VwdGlvbkluZm8uc3RhY2tUcmFjZVszNF2TbiQuZ2VuZXJpY0V4Y2VwdGlvbkluZm8uc3RhY2tUcmFjZVszNV2TbiQuZ2VuZXJpY0V4Y2VwdGlvbkluZm8uc3RhY2tUcmFjZVszNl2TbiQuZ2VuZXJpY0V4Y2VwdGlvbkluZm8uc3RhY2tUcmFjZVszN12TbiQuZ2VuZXJpY0V4Y2VwdGlvbkluZm8uc3RhY2tUcmFjZVszOF2TbiQuZ2VuZXJpY0V4Y2VwdGlvbkluZm8uc3RhY2tUcmFjZVszOV2TbiQuZ2VuZXJpY0V4Y2VwdGlvbkluZm8uc3RhY2tUcmFjZVs0MF2TbiQuZ2VuZXJpY0V4Y2VwdGlvbkluZm8uc3RhY2tUcmFjZVs0MV2TbiQuZ2VuZXJpY0V4Y2VwdGlvbkluZm8uc3RhY2tUcmFjZVs0Ml2TbiQuZ2VuZXJpY0V4Y2VwdGlvbkluZm8uc3RhY2tUcmFjZVs0M12TbiQuZ2VuZXJpY0V4Y2VwdGlvbkluZm8uc3RhY2tUcmFjZVs0NF2TbiQuZ2VuZXJpY0V4Y2VwdGlvbkluZm8uc3RhY2tUcmFjZVs0NV2TbiQuZ2VuZXJpY0V4Y2VwdGlvbkluZm8uc3RhY2tUcmFjZVs0Nl2TbiQuZ2VuZXJpY0V4Y2VwdGlvbkluZm8uc3RhY2tUcmFjZVs0N12TbiQuZ2VuZXJpY0V4Y2VwdGlvbkluZm8uc3RhY2tUcmFjZVs0OF2TbiQuZ2VuZXJpY0V4Y2VwdGlvbkluZm8uc3RhY2tUcmFjZVs0OV2TbiQuZ2VuZXJpY0V4Y2VwdGlvbkluZm8uc3RhY2tUcmFjZVs1MF2TbiQuZ2VuZXJpY0V4Y2VwdGlvbkluZm8uc3RhY2tUcmFjZVs1MV2TbiQuZ2VuZXJpY0V4Y2VwdGlvbkluZm8uc3RhY2tUcmFjZVs1Ml2TbiQuZ2VuZXJpY0V4Y2VwdGlvbkluZm8uc3RhY2tUcmFjZVs1M12TbiQuZ2VuZXJpY0V4Y2VwdGlvbkluZm8uc3RhY2tUcmFjZVs1NF2TbiQuZ2VuZXJpY0V4Y2VwdGlvbkluZm8uc3RhY2tUcmFjZVs1NV2TbiQuZ2VuZXJpY0V4Y2VwdGlvbkluZm8uc3RhY2tUcmFjZVs1Nl2TbiQuZ2VuZXJpY0V4Y2VwdGlvbkluZm8uc3RhY2tUcmFjZVs1N12TbiQuZ2VuZXJpY0V4Y2VwdGlvbkluZm8uc3RhY2tUcmFjZVs1OF2TbiQuZ2VuZXJpY0V4Y2VwdGlvbkluZm8uc3RhY2tUcmFjZVs1OV2TbiQuZ2VuZXJpY0V4Y2VwdGlvbkluZm8uc3RhY2tUcmFjZVs2MF2TbiQuZ2VuZXJpY0V4Y2VwdGlvbkluZm8uc3RhY2tUcmFjZVs2MV2TbiQuZ2VuZXJpY0V4Y2VwdGlvbkluZm8uc3RhY2tUcmFjZVs2Ml2TbiQuZ2VuZXJpY0V4Y2VwdGlvbkluZm8uc3RhY2tUcmFjZVs2M12TbiQuZ2VuZXJpY0V4Y2VwdGlvbkluZm8uc3RhY2tUcmFjZVs2NF2TbiQuZ2VuZXJpY0V4Y2VwdGlvbkluZm8uc3RhY2tUcmFjZVs2NV2TbiQuZ2VuZXJpY0V4Y2VwdGlvbkluZm8uc3RhY2tUcmFjZVs2Nl2TbiQuZ2VuZXJpY0V4Y2VwdGlvbkluZm8uc3RhY2tUcmFjZVs2N12TbiQuZ2VuZXJpY0V4Y2VwdGlvbkluZm8uc3RhY2tUcmFjZVs2OF2TbiQuZ2VuZXJpY0V4Y2VwdGlvbkluZm8uc3RhY2tUcmFjZVs2OV2TbiQuZ2VuZXJpY0V4Y2VwdGlvbkluZm8uc3RhY2tUcmFjZVs3MF1/U3N1cHByZXNzZWQNlKU=\"";
        byte[] jsonbBytes = JSON.parseObject(str, byte[].class, JSONReader.Feature.Base64StringAsByteArray);
        GenericException exception = (GenericException) JSONB.parseObject(
                jsonbBytes,
                Object.class, JSONReader.Feature.SupportAutoType,
                JSONReader.Feature.UseDefaultConstructorAsPossible,
                JSONReader.Feature.UseNativeObject,
                JSONReader.Feature.FieldBased
        );
        StackTraceElement[] stackTrace = exception.getStackTrace();
        assertNotNull(stackTrace);
    }
}
