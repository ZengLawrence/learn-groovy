def pattern = ~/(?x)
    \s+      # 1+ whitespace
    -{1,2}   # 1 or 2 hyphens
    \w[\w-]* # 1+ of word or hyphen characters starting with a word character
    \s+      # 1+ whitespace
    '[^']*'  # a string wrapped in single quotes
    /

assert "cmd -o '{}'" =~ pattern
assert 'cmd -o \'{"a": "b"}\'' =~ pattern
assert 'cmd --option \'{"a": "b"}\'' =~ pattern // failed
assert 'cmd --long-option \'{"a": "b"}\'' =~ pattern // failed
