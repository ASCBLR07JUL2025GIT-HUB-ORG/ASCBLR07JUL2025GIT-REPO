### :rocket: Email Regex Pattern Breakdown

```html
<input type="email" id="user-email" required 
       pattern="[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\.[a-zA-Z]{2,}$"
       value="john.doe@example.com">
```

---

#### :bulb: Local Part

```regex
[a-zA-Z0-9._%+-]+
```

- **`[...]`** – A character class, matches any one of the listed characters.
  - **`a-zA-Z`** – Matches any letter, lowercase (`a` to `z`) or uppercase (`A` to `Z`).
  - **`0-9`** – Matches any digit from `0` to `9`.
  - **`._%+-`** – Matches specific special characters commonly allowed in emails:
    - `.` (dot)
    - `_` (underscore)
    - `%` (percent)
    - `+` (plus)
    - `-` (hyphen)
- **`+`** – One or more of the preceding characters (the local part must have at least one character).

:dart: **This is the "local part" of the email (before the `@` symbol), e.g., `john.doe+test`.**

---

#### :gear: At Symbol

```regex
@
```

- A literal at symbol, separates the local part from the domain.
- **Mandatory.**

---

#### :triangular_ruler: Domain Name

```regex
[a-zA-Z0-9.-]+
```

- **Domain name part** (after `@` and before the final dot):
  - **`a-zA-Z0-9`** – Letters and digits
  - **`.`** and **`-`** – Dots (for subdomains) and hyphens (e.g., `my-company.com`)
- **`+`** – Ensures one or more characters are present.

:bulb: **Matches `gmail`, `sub.domain`, `example-site`, etc.**

---

#### :shield: Dot Separator

```regex
\.
```

- A literal dot (escaped with `\` to distinguish from regex's wildcard meaning).
- Separates the domain from the extension (e.g., `example.com`).

---

#### :brain: Domain Extension (TLD)

```regex
[a-zA-Z]{2,}
```

- **Domain extension** (aka TLD — Top-Level Domain):
  - Only letters allowed
  - Must be at least 2 characters long (e.g., `com`, `org`, `co`, `uk`, `info`)
  - `{2,}` means 2 or more characters

---

#### :dart: End Anchor

```regex
$
```

- Anchors the pattern to the end of the input.
- Ensures nothing extra follows (e.g., no accidental trailing characters).

---

### :white_check_mark: Examples That Match

- `john.doe@example.com`
- `user+promo@sub.domain.co.uk`
- `A_B.C-d@my-site.net`

---

### :warning: Examples That Don’t Match

- `john@.com` (no domain name before dot)
- `john@domain` (no TLD)
- `john@domain.c` (TLD only 1 letter)
- `@domain.com` (missing local part)

---