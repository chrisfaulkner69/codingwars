# Regular Expressions in The Code

## 1. Matching Decimal Numbers

**File:** MatchSubst.java

**Pattern:**
`public static final Pattern DECIMAL_PATTERN = Pattern.compile("[0-9]{1,}\\.[0-9]{1,}$");`

**Description:** This pattern matches decimal numbers. The regular expression `[0-9]{1,}\\.[0-9]{1,}$` translates to "one or more digits followed by a dot, again followed by one or more digits at the end of the string".

---

## 2. Word Splitting

**File:** PigLatin.java

**Pattern:**
`private static final Pattern regex = Pattern.compile("(\\w)(\\w*)");`

**Description:** This pattern splits words into two groups: the first character, and the rest of the word. `\w` matches any word character (equal to [a-zA-Z0-9_]) and `*` means zero or more of the preceding element.

---

## 3. Password Validation

**File:** RegexValidator.java

**Pattern:**
`public static final Pattern SIMPLE_PWD = Pattern.compile("^(?=.*\\d)(?=.*[a-z])(?=.*[A-Z])[A-Za-z\\d]{6,}$");`

**Description:** This pattern is used for password validation. It checks if the password has at least one digit (`(?=.*\\d)`), at least one lower case character (`(?=.*[a-z])`), at least one upper case character (`(?=.*[A-Z])`), and is at least 6 characters in length (`[A-Za-z\\d]{6,}$`).

---

## 4. 

**File:** PigLatin.java

**Pattern:** `(\\s)`

**Context:**
Arrays.stream(str.split("\\s"))


**Description:** Splits a string up by whitespace

---

**File:** PigLatin.java

**Pattern:** `"\\s+"`

The string `"\\s+"` is a regular expression in Java. Here's the breakdown of this regular expression:
- **`\\s`**: This matches any whitespace character. This includes spaces, tabs, and newline characters.
- **`+`**: This is a quantifier that matches one or more occurrences of the preceding element (in this case, the whitespace character).

So the regular expression `"\\s+"` matches one or more consecutive whitespace characters.

