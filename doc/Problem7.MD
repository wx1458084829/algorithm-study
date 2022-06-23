# 官网原题

#### [7. 整数反转](https://leetcode.cn/problems/reverse-integer/)

难度中等3539收藏分享切换为英文接收动态反馈

给你一个 32 位的有符号整数 `x` ，返回将 `x` 中的数字部分反转后的结果。

如果反转后整数超过 32 位的有符号整数的范围 `[−231, 231 − 1]` ，就返回 0。

**假设环境不允许存储 64 位整数（有符号或无符号）。**

 

**示例 1：**

```
输入：x = 123
输出：321
```

**示例 2：**

```
输入：x = -123
输出：-321
```

**示例 3：**

```
输入：x = 120
输出：21
```

**示例 4：**

```
输入：x = 0
输出：0
```

 

**提示：**

- `-231 <= x <= 231 - 1`

# 个人解法

* 堆栈

  ```java
  /**
   * 采用栈解决
   * @param x
   * @return
   */
  public int reverse(int x) {
      if (x == 0) {
          return 0;
      }
      boolean isLow = false;
      if (x < 0) {
          isLow = true;
      }
      x = Math.abs(x);
  
      Stack<Character> characterStack = new Stack<>();
      char[] numberChars = String.valueOf(x).toCharArray();
      for (char numberChar : numberChars) {
          characterStack.push(numberChar);
      }
      String outString = "";
      int size = characterStack.size();
      for (int i = 0; i < size; i++) {
          outString += characterStack.pop();
      }
  
      try {
          Integer.valueOf(outString);
      } catch (Exception e) {
          return 0;
      }
      return isLow ? -Integer.valueOf(outString) : Integer.valueOf(outString);
  }
  ```

* 递归

```java
String countNumber = "";

/**
 * 递归方法
 *
 * @param x
 * @return
 */
public int reverse(int x) {
    boolean isLow = x < 0 ? true : false;
    x = Math.abs(x);
    reverseFn(x);
    try {
        Integer.valueOf(countNumber);
    } catch (Exception e) {
        return 0;
    }
    return isLow ? -Integer.valueOf(countNumber) : Integer.valueOf(countNumber);
}

public int reverseFn(int x) {
    countNumber += String.valueOf(x % 10);
    if (x / 10 == 0) {
        return x;
    } else {
        return reverseFn(x / 10);
    }
}
```

* 采用String Builder

```java
/**
 * 直接使用string builder的字符串反转方法
 *
 * @param x
 * @return
 */
public int reverse(int x) {
    if (x == 0) {
        return 0;
    }
    boolean isLow = x < 0 ? true : false;
    x = Math.abs(x);
    String xString = String.valueOf(x);
    StringBuilder xBuilder = new StringBuilder(xString);
    StringBuilder reverseBuilder = xBuilder.reverse();
    try {
        Integer.parseInt(reverseBuilder.toString());
    } catch (Exception e) {
        return 0;
    }
    return isLow ? -Integer.parseInt(reverseBuilder.toString()) : Integer.parseInt(reverseBuilder.toString());
}
```

# 评论优秀解法



# 题后思考

* 在解决这个问题的时候涉及到String转int ，已知String转int有两种方法，即Integer.parseInt()和Integer.valueOf()，但是Integer.valueOf()的时间复杂度比 Integer.parseInt()高。

  Integer.parseInt()的底层代码：

  ```java
  /**
   * Parses the string argument as a signed decimal integer. The
   * characters in the string must all be decimal digits, except
   * that the first character may be an ASCII minus sign {@code '-'}
   * ({@code '\u005Cu002D'}) to indicate a negative value or an
   * ASCII plus sign {@code '+'} ({@code '\u005Cu002B'}) to
   * indicate a positive value. The resulting integer value is
   * returned, exactly as if the argument and the radix 10 were
   * given as arguments to the {@link #parseInt(java.lang.String,
   * int)} method.
   *
   * @param s    a {@code String} containing the {@code int}
   *             representation to be parsed
   * @return     the integer value represented by the argument in decimal.
   * @exception  NumberFormatException  if the string does not contain a
   *               parsable integer.
   */
  public static int parseInt(String s) throws NumberFormatException {
      return parseInt(s,10);
  }
  
  
  
  
      /**
       * Parses the string argument as a signed integer in the radix
       * specified by the second argument. The characters in the string
       * must all be digits of the specified radix (as determined by
       * whether {@link java.lang.Character#digit(char, int)} returns a
       * nonnegative value), except that the first character may be an
       * ASCII minus sign {@code '-'} ({@code '\u005Cu002D'}) to
       * indicate a negative value or an ASCII plus sign {@code '+'}
       * ({@code '\u005Cu002B'}) to indicate a positive value. The
       * resulting integer value is returned.
       *
       * <p>An exception of type {@code NumberFormatException} is
       * thrown if any of the following situations occurs:
       * <ul>
       * <li>The first argument is {@code null} or is a string of
       * length zero.
       *
       * <li>The radix is either smaller than
       * {@link java.lang.Character#MIN_RADIX} or
       * larger than {@link java.lang.Character#MAX_RADIX}.
       *
       * <li>Any character of the string is not a digit of the specified
       * radix, except that the first character may be a minus sign
       * {@code '-'} ({@code '\u005Cu002D'}) or plus sign
       * {@code '+'} ({@code '\u005Cu002B'}) provided that the
       * string is longer than length 1.
       *
       * <li>The value represented by the string is not a value of type
       * {@code int}.
       * </ul>
       *
       * <p>Examples:
       * <blockquote><pre>
       * parseInt("0", 10) returns 0
       * parseInt("473", 10) returns 473
       * parseInt("+42", 10) returns 42
       * parseInt("-0", 10) returns 0
       * parseInt("-FF", 16) returns -255
       * parseInt("1100110", 2) returns 102
       * parseInt("2147483647", 10) returns 2147483647
       * parseInt("-2147483648", 10) returns -2147483648
       * parseInt("2147483648", 10) throws a NumberFormatException
       * parseInt("99", 8) throws a NumberFormatException
       * parseInt("Kona", 10) throws a NumberFormatException
       * parseInt("Kona", 27) returns 411787
       * </pre></blockquote>
       *
       * @param      s   the {@code String} containing the integer
       *                  representation to be parsed
       * @param      radix   the radix to be used while parsing {@code s}.
       * @return     the integer represented by the string argument in the
       *             specified radix.
       * @exception  NumberFormatException if the {@code String}
       *             does not contain a parsable {@code int}.
       */
      public static int parseInt(String s, int radix)
                  throws NumberFormatException
      {
          /*
           * WARNING: This method may be invoked early during VM initialization
           * before IntegerCache is initialized. Care must be taken to not use
           * the valueOf method.
           */
  		//字符串为空就抛出异常
          if (s == null) {
              throw new NumberFormatException("null");
          }
  		//进制如果小于最小进制2就抛出异常
          if (radix < Character.MIN_RADIX) {
              throw new NumberFormatException("radix " + radix +
                                              " less than Character.MIN_RADIX");
          }
  		//进制如果大于最大进制36就抛出异常
          if (radix > Character.MAX_RADIX) {
              throw new NumberFormatException("radix " + radix +
                                              " greater than Character.MAX_RADIX");
          }
  		// 存储最终结果
          int result = 0;
          // 存储标志(转换的数是否是负数)
          boolean negative = false;
          //i为下标 len为传入的字符串长度
          int i = 0, len = s.length();
          // 能取到的最值
          int limit = -Integer.MAX_VALUE;
          // 乘积最小值
          int multmin;
          // 当前扫描到的值 的int值
          int digit;
  
          // 如果长度大于零才计算，否则抛出异常
          if (len > 0) {
              char firstChar = s.charAt(0);
              // 如果firstChar可能是"+" 或 "-"，那么判断符号是否为"+" 或 "-"，否则默认为"+"
              if (firstChar < '0') { // Possible leading "+" or "-"（可能为"+" 或 "-"）-->因为"+" 或 "-"的ASCII码在'0'之前，并且当firstChar > '0'说明可能是不带"+"的正数
                  // 如果为负数，那么设置标志为true
                  if (firstChar == '-') {
                      negative = true;
                      //设置限制最大大小
                      limit = Integer.MIN_VALUE;
                  } 
                  //如果不为正也不为负那么就是非法的，抛出异常
                  else if (firstChar != '+')
                      throw NumberFormatException.forInputString(s);
  				//如果长度为1的话是错误的
                  if (len == 1) // Cannot have lone "+" or "-" 不能单独存在"+" 或 "-"
                      throw NumberFormatException.forInputString(s);
                  //下标自增
                  i++;
              }
              
              //计算除个位外的的数位，除以进制(radix)就得到了少一位的数，为什么要除以进制，
              multmin = limit / radix;
              while (i < len) {
                  // Accumulating negatively avoids surprises near MAX_VALUE （负累积可避免 MAX_VALUE 附近出现意外）
                  digit = Character.digit(s.charAt(i++),radix);
                  //如果取出来的是负数就抛异常
                  if (digit < 0) {
                      throw NumberFormatException.forInputString(s);
                  }
                  //如果当前累减的值小于 设定值 ，则抛异常。
                  if (result < multmin) {
                      throw NumberFormatException.forInputString(s);
                  }
                  //进位 
                  result *= radix;
                  //设定值加上进位如果比结果大，说明超过范围了，需要抛出异常 
                  if (result < limit + digit) {
                      throw NumberFormatException.forInputString(s);
                  }
                  //累减
                  result -= digit;
              }
          } else {
              throw NumberFormatException.forInputString(s);
          }
          //因为这里是累减，所以如果是negative为真的时候直接返回负数，反之返回相反数
          return negative ? result : -result;
      }
  
  
  ```


> 问：为什么要用累减，而不是累加？
>
> 答：根据源代码的注释( Accumulating negatively avoids surprises near MAX_VALUE )，可以得到是说累减是可以避免在MAX_VALUE(Integer最大值常量)出现错误。具体分析如下。
>
> 1. 我们观看源代码得到min的绝对值要比max绝对值大。
>
> ````java
>     /**
>      * A constant holding the minimum value an {@code int} can
>      * have, -2<sup>31</sup>.
>      */
>     @Native public static final int   MIN_VALUE = 0x80000000;
> 
>     /**
>      * A constant holding the maximum value an {@code int} can
>      * have, 2<sup>31</sup>-1.
>      */
>     @Native public static final int   MAX_VALUE = 0x7fffffff;
> ````
>
> 2. min绝对值大于max绝对值，但是方法parseInt()传入是正数也可能是负数，而计算最后结果的时候只能采用累加和累减(粗暴分开情况写代码会很冗余，大牛是不会那样写的)，故必须固定用累加或累减，我们由上面得知，**要想全部数都能用int表示(可大不可小)，那么只能用累减，因为min的绝对值要比max绝对值大，所以只有用负数才能表示最值。**
>
> 
>
> 问：`if (result < multmin) `和`if (result < limit + digit) `有什么相同和不同？
>
> 答：
>
> 相同点：
>
> * 两个if都是判断数值是否超过最值的。
>
> 不同点：
>
> * `if (result < multmin) `是判断`result *= radix;`操作是否越界的。
>   * 其中`multmin`是来自最值除以进制，因为每次`result *= radix;`操作都是结果乘以进制，但是由于`if (result < multmin) `是在执行累乘(`result *= radix;`)之前判断，那么相对于执行n次`result *= radix;`只判断n-1次`if (result < multmin) `，所以`multmin`是需要用最值除以进制。
> * `if (result < limit + digit) `是判断`result -= digit;`操作是否越界的[^1]。
>   * 这个是确保累减的合法性，一般情况下`result` 是大于`limit + digit`的，但是当前面累乘的结果如果和`multmin`一样，那么说明当前只剩最后一位数据需要累减，那么要确保最后一次操作的合法性，这个时候就要先尝试累减( 即`limit + digit`)[^2]，合法以后才能真正地进行累减操作。
> * 实质上来讲，大牛这样写(`if (result < limit + digit) `--->`result -= digit;`)是**提前判断了下一步操作的可行性，然后再进行操作**，而(`if (result < multmin) `---->`result *= radix;`)是操作了再判断可行性，且由上述知道前一步判断相比操作要少一次。
>
> 
>
> 问：为什么（`if (result < multmin) `  `result *= radix;`）和（`if (result < limit + digit) ` ` result -= digit;`）他们里面的执行次数和顺序为什么不一样？
>
> 答：前者：是`limit`首先向前进一位得到`multmin`，然后与`result`比较，但是假设打破这个原则。
>
> * 如果先执行 `result *= radix;`再执行`if (result < multmin)`
>
>  ````java
>   			//计算除个位外的的数位，除以进制(radix)就得到了少一位的数，为什么要除以进制，
>             multmin = limit / radix;
>      			//进位 
>                   result *= radix;
>                   //设定值加上进位如果比结果大，说明超过范围了，需要抛出异常 
>                  if (result < multmin) {
>                     throw NumberFormatException.forInputString(s);
>                 }
> ````
> 
>不符合程序的要求，这个会提前判断超出大小，答案是错误的。
> 
>* 如果`limit`不除进制，然后直接判断`result < limit`，那么会导致出现-123（假设最大值）> -990（假设结果已经累乘三位了，输入是999），这个时候显然会报错的，因为计算出来的的值已经大于`limit`了，所以为什么一定要往前移位进制之后进行判断，并且累乘不像累减能够通过提前加上一个数进行判断，这里累乘一旦尝试去累乘一个大于最值的数，必定出错，故最好往前移动进行判断前面n-1位的合理性，然后再判断最后一位，可见设计的非常巧妙！

分析得出Integer.parseInt()的效率比Integer.valueOf() 的效率高，原因是Integer.valueOf() 的返回值是Integer，而变为int还需要拆箱。



* Integer.valueOf()方法



[^1]: 为什么需要多下面这一步判断，因为上面的判断`if (result < multmin)`只能判断进制前`n-1`位，最后一位还是需要额外判断。
[^2]: 为什么使用`result < limit + digit`作为判断条件，而不用`result - digit < limit`，因为用`result`来减`digit`可能会比`limit`还小,所以有超出最值的风险，故只能使用前者。



