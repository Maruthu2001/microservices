package com.auth.check.json_check.studiesFolder.JavaRunFiles;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.graalvm.polyglot.Context;
import org.graalvm.polyglot.HostAccess;
import org.graalvm.polyglot.Value;


public class Engine {
    
    public static void main(String[] args) {
        String script = "bigDecimalAddVue = (inputValue, paramsList) => {\r\n"
                + "if (inputValue === null || inputValue === undefined) {\r\n"
                + "    inputValue = \"0.0\";\r\n"
                + "  }\r\n"
                + "\r\n"
                + "  let addedValueStr = \"0.0\";\r\n"
                + "\r\n"
                + "  for (const appgenMapValue of paramsList) {\r\n"
                + "    const paramValue = appgenMapValue.paramValue !== undefined && appgenMapValue.paramValue !== null ? String(appgenMapValue.paramValue) : \"0.0\";\r\n"
                + "    addedValueStr = paramValue; // Mimicking the overwrite behavior\r\n"
                + "  }\r\n"
                + "\r\n"
                + "  const add = (num1Str, num2Str) => {\r\n"
                + "    const [integer1, decimal1] = num1Str.split('.');\r\n"
                + "    const [integer2, decimal2] = num2Str.split('.');\r\n"
                + "    const integerPart = String(BigInt(integer1 || '0') + BigInt(integer2 || '0'));\r\n"
                + "    const maxLength = Math.max((decimal1 || '').length, (decimal2 || '').length);\r\n"
                + "    const paddedDecimal1 = (decimal1 || '').padEnd(maxLength, '0');\r\n"
                + "    const paddedDecimal2 = (decimal2 || '').padEnd(maxLength, '0');\r\n"
                + "\r\n"
                + "    const decimalSum = String(BigInt(paddedDecimal1) + BigInt(paddedDecimal2)).padStart(maxLength, '0');\r\n"
                + "\r\n"
                + "    if (decimalSum.length > maxLength) {\r\n"
                + "      const carry = BigInt(decimalSum.slice(0, decimalSum.length - maxLength));\r\n"
                + "      const remainingDecimal = decimalSum.slice(-maxLength);\r\n"
                + "      return `${BigInt(integerPart) + carry}.${remainingDecimal}`;\r\n"
                + "    } else if (maxLength > 0) {\r\n"
                + "      return `${integerPart}.${decimalSum}`;\r\n"
                + "    } else {\r\n"
                + "      return integerPart;\r\n"
                + "    }\r\n"
                + "  };\r\n"
                + "\r\n"
                + "  const inputValueStr = String(inputValue);\r\n"
                + "  return add(inputValueStr, addedValueStr);\r\n"
                + "};";
        
        String script1 = "bigDecimalDivideVue = (inputValue, paramsList) => {\r\n"
                + "  if (inputValue === null || inputValue === undefined) {\r\n"
                + "    inputValue = \"0.0\";\r\n"
                + "  }\r\n"
                + "\r\n"
                + "  let divisorStr = \"1\";\r\n"
                + "  let scale = 0;\r\n"
                + "\r\n"
                + "  for (const appgenMapValue of paramsList) {\r\n"
                + "    const paramKey = appgenMapValue.paramKey;\r\n"
                + "    const paramValue =\r\n"
                + "      appgenMapValue.paramValue !== undefined && appgenMapValue.paramValue !== null\r\n"
                + "        ? String(appgenMapValue.paramValue)\r\n"
                + "        : \"0.0\";\r\n"
                + "\r\n"
                + "    if (paramKey === \"Scale\") {\r\n"
                + "      const parsedScale = parseInt(paramValue);\r\n"
                + "      if (!isNaN(parsedScale)) {\r\n"
                + "        scale = parsedScale;\r\n"
                + "      }\r\n"
                + "    } else if (paramKey === \"Value\") {\r\n"
                + "      divisorStr = paramValue;\r\n"
                + "    }\r\n"
                + "  }\r\n"
                + "\r\n"
                + "  const dividendStr = String(inputValue);\r\n"
                + "\r\n"
                + "  if (divisorStr === \"0\" || divisorStr === \"0.0\") {\r\n"
                + "    return \"Division by zero\";\r\n"
                + "  }\r\n"
                + "\r\n"
                + "  return performDivisionRevised(dividendStr, divisorStr, scale);\r\n"
                + "\r\n"
                + "  function performDivisionRevised(dividend, divisor, scale) {\r\n"
                + "    let [dividendInteger = \"0\", dividendDecimal = \"\"] = dividend.split(\".\");\r\n"
                + "    let [divisorInteger = \"0\", divisorDecimal = \"\"] = divisor.split(\".\");\r\n"
                + "\r\n"
                + "    const dividendMantissa = dividendInteger + dividendDecimal;\r\n"
                + "    const divisorMantissa = divisorInteger + divisorDecimal;\r\n"
                + "\r\n"
                + "    const dividendDecimalLength = dividendDecimal.length;\r\n"
                + "    const divisorDecimalLength = divisorDecimal.length;\r\n"
                + "\r\n"
                + "    const normalizationFactor = Math.max(dividendDecimalLength, divisorDecimalLength);\r\n"
                + "    const dividendBigInt = BigInt(dividendMantissa + \"0\".repeat(normalizationFactor - dividendDecimalLength));\r\n"
                + "    const divisorBigInt = BigInt(divisorMantissa + \"0\".repeat(normalizationFactor - divisorDecimalLength));\r\n"
                + "    const scaleFactor = BigInt(\"1\" + \"0\".repeat(scale));\r\n"
                + "\r\n"
                + "    let quotientBigInt = (dividendBigInt * scaleFactor) / divisorBigInt;\r\n"
                + "    let quotientStr = String(quotientBigInt);\r\n"
                + "\r\n"
                + "    const integerPartLength = quotientStr.length - scale;\r\n"
                + "    let integerPart = integerPartLength > 0 ? quotientStr.slice(0, integerPartLength) : \"0\";\r\n"
                + "    let fractionalPart = scale > 0 ? quotientStr.slice(-scale).padStart(scale, \"0\") : \"\";\r\n"
                + "\r\n"
                + "    let result =\r\n"
                + "      integerPart +\r\n"
                + "      (scale > 0 && fractionalPart !== \"0\".repeat(scale)\r\n"
                + "        ? \".\" + fractionalPart\r\n"
                + "        : scale > 0\r\n"
                + "          ? \".\" + \"0\".repeat(scale)\r\n"
                + "          : \"\");\r\n"
                + "\r\n"
                + "    // Rounding HALF_UP\r\n"
                + "    if (scale > 0 && result.includes(\".\") && result.split(\".\")[1].length > scale) {\r\n"
                + "      const parts = result.split(\".\");\r\n"
                + "      let integer = parts[0];\r\n"
                + "      let fraction = parts[1];\r\n"
                + "\r\n"
                + "      if (parseInt(fraction[scale]) >= 5) {\r\n"
                + "        let carry = 1;\r\n"
                + "        let roundedFractionArr = fraction.slice(0, scale).split(\"\").reverse();\r\n"
                + "        for (let i = 0; i < roundedFractionArr.length; i++) {\r\n"
                + "          const digit = parseInt(roundedFractionArr[i]) + carry;\r\n"
                + "          roundedFractionArr[i] = String(digit % 10);\r\n"
                + "          carry = Math.floor(digit / 10);\r\n"
                + "          if (carry === 0) {\r\n"
                + "            break;\r\n"
                + "          }\r\n"
                + "        }\r\n"
                + "        let roundedFraction = roundedFractionArr.reverse().join(\"\");\r\n"
                + "        if (carry > 0) {\r\n"
                + "          integer = String(BigInt(integer) + BigInt(carry));\r\n"
                + "        }\r\n"
                + "        result = integer + (roundedFraction ? \".\" + roundedFraction : \"\");\r\n"
                + "      } else {\r\n"
                + "        result = integer + (fraction.slice(0, scale) ? \".\" + fraction.slice(0, scale) : \"\");\r\n"
                + "      }\r\n"
                + "      if (result.endsWith(\".\")) {\r\n"
                + "        result = result.slice(0, -1);\r\n"
                + "      }\r\n"
                + "    } else if (scale > 0 && result.includes(\".\") && result.split(\".\")[1].length < scale) {\r\n"
                + "      result = result.split(\".\")[0] + \".\" + result.split(\".\")[1].padEnd(scale, \"0\");\r\n"
                + "    } else if (scale > 0 && !result.includes(\".\")) {\r\n"
                + "      result += \".\" + \"0\".repeat(scale);\r\n"
                + "    }\r\n"
                + "\r\n"
                + "    return result;\r\n"
                + "  }\r\n"
                + "};\r\n"
                + "";
        
        Double inputValue = null;
        List<Map<String, Object>> paramList = new ArrayList<>();
        Map<String, Object> param1 = new HashMap<>();
        param1.put("paramValue", 10);
        paramList.add(param1);
        
        try(Context cont = Context.newBuilder("js").allowHostAccess(HostAccess.ALL).build()) {
//            cont.eval("js", script);            
//            Value bigDecimalValue = cont.getBindings("js").getMember("bigDecimalAddVue");
//            Value result = bigDecimalValue.execute(inputValue, paramList);
            
            cont.eval("js", script1);
            Value bigDecimalDecimalFormatVue = cont.getBindings("js").getMember("bigDecimalDivideVue");
            Value result = bigDecimalDecimalFormatVue.execute(inputValue, paramList);
            
            System.out.println("Data -> " + result);
        }
    }
}
