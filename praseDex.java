/*************************************************************************
	> File Name: praseDex.java
	> Author: 
	> Mail: 
	> Created Time: 2017年03月15日 星期三 20时14分05秒
 ************************************************************************/
import java.io.*;
import java.util.Arrays;
public class praseDex{
    DexHeader dh = new DexHeader();
    public static void praseDexFile(String filepath){
        byte[] fileByte = null;
        try(
        InputStream is = new FileInputStream(filepath);
        ByteArrayOutputStream bos = new ByteArrayOutputStream())
        {
            byte[] buffer = new byte[4096];
            int len = 0;
            while((len = is.read(buffer)) != -1){
                bos.write(buffer,0,len);
            }
            fileByte = bos.toByteArray();
        }catch(IOException e){
            //e.printStacktrace();
        }
        if(fileByte == null){
            System.out.println("get dex error!!!");
        }
        String[] result = byteTOHexString(fileByte);
        //System.out.println(Arrays.toString(fileByte));
        for(int i = 0; i < result.length; i++){
            if((i+1)%16 !=0)
                System.out.print(result[i] + " ");
            else
                System.out.print(result[i] + "\n");
        }
       System.out.println(""); 
    }
    public static String[] byteTOHexString(byte[] b){
        if(b.length == 0 || b == null)
            return null;
        String[] result = new String[b.length];
        for(int i = 0; i < b.length; i++){
            int v = b[i] & 0xFF;
            System.out.print(v+" ");
            String hv = Integer.toHexString(v);
            if(hv.length() < 2){
                hv = '0'+ hv;
            }
            result[i] = hv.toUpperCase();
        }
        return result;
    }
    
    public static void main(String[] args){
        praseDexFile(args[0]);
    }
}
class DexHeader {
    private int kSHA1DigestLen = 20;
    private byte[] magic = new byte[8];        
    private int checksum;           
    private byte[] signature = new byte[kSHA1DigestLen]; 
    private int fileSize;         
    private int headerSize;       
    private int endianTag;
    private int linkSize;
    private int linkOff;
    private int mapOff;
    private int stringIdsSize;
    private int stringIdsOff;
    private int typeIdsSize;
    private int typeIdsOff;
    private int protoIdsSize;
    private int protoIdsOff;
    private int fieldIdsSize;
    private int fieldIdsOff;
    private int methodIdsSize;
    private int methodIdsOff;
    private int classDefsSize;
    private int classDefsOff;
    private int dataSize;
    private int dataOff;
    public void setMagic(byte[] magic){
        if(magic.length == 8)
            this.magic = magic;
    }
    public byte[] getMagic(){
        return magic;
    }
    public void setChecksum(int checksum){
        this.checksum = checksum;
    }
    public int getChecksum(){
        return checksum;
    }
    public void setSignature(byte[] signature){
        if(signature.length == 20)
            this.signature = signature;
    }
    public byte[] getSignature(){
        return signature;
    }
    public void setFileSize(int size){
        this.fileSize = size;
    }
    public int getFileSize(){
        return fileSize;
    }
    public void setHeaderSize(int size){
        this.headerSize = size;
    }
    public int getHeaderSize(){
        return headerSize;
    }
    public void setEndianTag(int endianTag){
        this.endianTag = endianTag;
    }
    public int getEndianTag(){
        return endianTag;
    }
    public void setLinkSize(int size){
        this.linkSize = size;
    }
    public int getLinkSize(){
        return linkSize;
    }
    public void setLinkOff(int off){
        this.linkOff = off;
    }
    public int getLinkOff(){
        return linkOff;
    }
    public void setMapOff(int off){
        this.mapOff = off;
    }
    public int getMapOff(){
        return mapOff;
    }
    public void setStringIdsSize(int size){
        this.stringIdsSize = size;
    }
    public int getStringIdsSize(){
        return stringIdsSize;
    }
    public void setStringIdsOff(int off){
        this.stringIdsOff = off;
    }
    public int getStringIdsOff(){
        return stringIdsOff;
    }
    public void setTypeIdsSize(int size){
        this.typeIdsSize = size;
    } 
    public int getTypeIdsSize(){
        return typeIdsSize;
    }
    public void setTypeIdsOff(int off){
        this.typeIdsOff = off;
    }
    public int getTypeIdsOff(){
        return typeIdsOff;
    }
    public void setProtoIdsSize(int size){
        this.protoIdsSize = size;
    }
    public int getProtoIdsSize(){
        return protoIdsSize;
    }
    public void setProtoIdsOff(int off){
        this.protoIdsOff = off;
    }
    public int getProtoIdsOff(){

        return protoIdsOff;
    }
    public void setFieldIdsSize(int size){
        this.fieldIdsSize = size;
    }
    public int getFieldIdsSize(){
        return fieldIdsSize;
    }
    public void setFieldIdsOff(int off){
        this.fieldIdsOff = off;
    }
    public int getFieldIdsOff(){
        return fieldIdsOff;
    }
    public void setMethodIdsSize(int size){
        this.methodIdsSize = size;
    }
    public int getMethodIdsSize(){
        return methodIdsSize;
    }
    public void setMethodIdsOff(int off){
        this.methodIdsOff = off;
    }
    public int getMethodIdsOff(){
        return methodIdsOff;
    }
    public void setClassDefsSize(int size){
        this.classDefsSize = size;
    }
    public int getclassDefsSize(){
        return classDefsSize;
    }
    public void setClassDefsOff(int off){
        this.classDefsOff = off;
    }
    public int getClassDefsOff(){
        return classDefsOff;
    }
    public void setDataSize(int size ){
        this.dataSize = size;
    }
    public int getDataSize(){
        return dataSize;
    }
    public void setDataOff(int off){
        this.dataOff = off;
    }
    public int getDataOff(){
        return dataOff;
    }

}

