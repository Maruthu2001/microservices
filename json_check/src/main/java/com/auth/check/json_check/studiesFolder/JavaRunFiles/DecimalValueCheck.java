package com.auth.check.json_check.studiesFolder.JavaRunFiles;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DecimalValueCheck {
    
    public static void main(String[] args) {
        
        BigDecimal bd = new BigDecimal("123.4567890123456789");
        double d = bd.doubleValue();
        System.out.println("BigDecimal value: " + bd);
        System.out.println("Double value: " + d);
//       Double dd = 156116116511d;
//       dd += dd;
//       System.out.println(dd);
//       
//       BigDecimal ddd = new BigDecimal("156116116511");
//       ddd.add(ddd);
//       System.out.println(ddd);
        List<Map<String, Object>> paramList = new ArrayList<>();
        Map<String, Object> param1 = new HashMap<>();
        param1.put("paramValue", 5555);
        paramList.add(param1);
        System.out.println(bigDecimalDecimalFormat(new BigDecimal(6161), paramList));
    }
    
    public static BigDecimal bigDecimalDecimalFormat(BigDecimal inputValue, List<Map<String, Object>> appgenListValue) {
        Object precision = null;
        int finalPrecision = 0;
        BigDecimal formattedBigDecimal = null;
        if (inputValue == null || inputValue.compareTo(BigDecimal.ZERO) == 0) {
            inputValue = new BigDecimal(0);
        }
        for (Map<String, Object> appgenMapValue : appgenListValue) {
            precision = appgenMapValue.get("paramValue");
        }
        if (precision instanceof Number) {
            finalPrecision = ((Number) precision).intValue();
        }
        formattedBigDecimal = inputValue.setScale(finalPrecision, RoundingMode.HALF_EVEN);
        return formattedBigDecimal;
    }
}
