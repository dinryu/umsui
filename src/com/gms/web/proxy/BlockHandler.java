package com.gms.web.proxy;

import javax.servlet.http.HttpServletRequest;

public class BlockHandler {

    public static int[] attr(PageProxy pxy){
    	int[] result = new int[6];
    	int theNumberOfPages=0, startPage=0,endPage=0;
    	theNumberOfPages =(pxy.getTheNumberOfRows() % pxy.getPageSize()) ==0 ?
    			pxy.getTheNumberOfRows() / pxy.getPageSize()
    			: pxy.getTheNumberOfRows() / pxy.getPageSize() + 1;
    	startPage = pxy.getPageNumber() -((pxy.getPageNumber()-1) % pxy.getBlockSize());
    	endPage =(startPage + pxy.getBlockSize() -1 <= theNumberOfPages) ?
    			startPage + pxy.getBlockSize() -1 : theNumberOfPages;
        result[0] = pxy.getPageNumber();
        result[1] = theNumberOfPages;
        result[2] = startPage;
        result[3] = endPage;
        result[4] = startPage -(theNumberOfPages/pxy.getBlockSize());//prev
        result[5] = startPage -(theNumberOfPages/pxy.getBlockSize());//next
        System.out.println("BlockHandler¿¡¼­ PageNumber: "+result[0] +",\n"+
        		           "theNumberOfPages: "+result[1] +",\n"+
        		           "startPage: "+result[2] +",\n"+
        		           "endPage: "+result[3] +",\n"+
        		           "preveBlock: "+result[4] +",\n"+     		          
        		           "nextBlock: "+result[5] +",\n");
    	return result;   	
    }
}
