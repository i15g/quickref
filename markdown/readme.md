# Markdown Quickref

## Basics

```markdown
_Italics_

**Bold**

~~Strikethrough~~

`Inline Code`

> Inline Quote

--- (Divider / Horizontal rule)

[Link Example](example.org)

![alt text](path/image.jpg)
```

## Headings

There are 6 levels of headings. In descending size order:

```
# Heading      1 (largest)
## Heading     2
### Heading    3
#### Heading   4
##### Heading  5
###### Heading 6 (smallest)
```

## Lists

### Bullet points

- One
  - A
  - B
- Two
  - C
- Three

### Numbered

Most renderers will automatically handle numbering, though you can certainly increment them yourself.

1. One
1. Two
1. Three

### Mixed

- Item
  1. First Subitem
  2. Second Subitem
- Item
  - Subitem
  - Subitem
- Item

Doesn't work in most renderers:

```
1. One
  - A
  - B
2. Two
  - C
3. Three
```

### Checklist

- [x] Milk
- [ ] Eggs
- [ ] Coffee

## Tables

| Header 1 | Header 2 | Header 3 |
| -------- | -------- | -------- |
| Data 1A  | Data 1B  | Data 1C  |
| Data 2A  | Data 2B  | Data 2C  |
| Data 3A  | Data 3B  | Data 3C  |

Export from excel/csv/spreadsheet to markdown:

- https://thisdavej.com/copy-table-in-excel-and-paste-as-a-markdown-table/
- https://tabletomarkdown.com/convert-spreadsheet-to-markdown/

## Code block

```java
//This is a java code block
public static void main(String args[]){

}
```

## Quote Block

> This is a multiline quote block.
>
> Linebreaks get their own `>` char.

## Formatters

- TODO
