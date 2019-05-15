package com;

class Builtin
{
    public String info = "default rel\n" +
            "\n" +
            "global print: function\n" +
            "global println: function\n" +
            "global printInt: function\n" +
            "global printlnInt: function\n" +
            "global getString: function\n" +
            "global getInt: function\n" +
            "global toString: function\n" +
            "global str_concat: function\n" +
            "global str_equal: function\n" +
            "global str_not_equal: function\n" +
            "global str_less: function\n" +
            "global str_lte: function\n" +
            "global parseInt: function\n" +
            "global ord: function\n" +
            "global substring: function\n" +
            "global main: function\n" +
            "global REG_SIZE\n" +
            "\n" +
            "extern strcmp                                           ; near\n" +
            "extern getchar                                          ; near\n" +
            "extern strlen                                           ; near\n" +
            "extern __isoc99_scanf                                   ; near\n" +
            "extern malloc                                           ; near\n" +
            "extern __stack_chk_fail                                 ; near\n" +
            "extern putchar                                          ; near\n" +
            "extern puts                                             ; near\n" +
            "extern printf                                           ; near\n" +
            "extern _GLOBAL_OFFSET_TABLE_                            ; byte\n" +
            "\n" +
            "\n" +
            "SECTION .text   align=1 execute                         ; section number 1, code\n" +
            "\n" +
            "print:  ; Function begin\n" +
            "        push    rbp                                     ; 0000 _ 55\n" +
            "        mov     rbp, rsp                                ; 0001 _ 48: 89. E5\n" +
            "        sub     rsp, 16                                 ; 0004 _ 48: 83. EC, 10\n" +
            "        mov     qword [rbp-8H], rdi                     ; 0008 _ 48: 89. 7D, F8\n" +
            "        mov     eax, 8                                  ; 000C _ B8, 00000008\n" +
            "        mov     edx, eax                                ; 0011 _ 89. C2\n" +
            "        mov     rax, qword [rbp-8H]                     ; 0013 _ 48: 8B. 45, F8\n" +
            "        add     rax, rdx                                ; 0017 _ 48: 01. D0\n" +
            "        mov     rsi, rax                                ; 001A _ 48: 89. C6\n" +
            "        lea     rdi, [rel ?_054]                        ; 001D _ 48: 8D. 3D, 00000000(rel)\n" +
            "        mov     eax, 0                                  ; 0024 _ B8, 00000000\n" +
            "        call    printf                                  ; 0029 _ E8, 00000000(PLT r)\n" +
            "        nop                                             ; 002E _ 90\n" +
            "        leave                                           ; 002F _ C9\n" +
            "        ret                                             ; 0030 _ C3\n" +
            "; print End of function\n" +
            "\n" +
            "println:; Function begin\n" +
            "        push    rbp                                     ; 0031 _ 55\n" +
            "        mov     rbp, rsp                                ; 0032 _ 48: 89. E5\n" +
            "        sub     rsp, 16                                 ; 0035 _ 48: 83. EC, 10\n" +
            "        mov     qword [rbp-8H], rdi                     ; 0039 _ 48: 89. 7D, F8\n" +
            "        mov     eax, 8                                  ; 003D _ B8, 00000008\n" +
            "        mov     edx, eax                                ; 0042 _ 89. C2\n" +
            "        mov     rax, qword [rbp-8H]                     ; 0044 _ 48: 8B. 45, F8\n" +
            "        add     rax, rdx                                ; 0048 _ 48: 01. D0\n" +
            "        mov     rdi, rax                                ; 004B _ 48: 89. C7\n" +
            "        call    puts                                    ; 004E _ E8, 00000000(PLT r)\n" +
            "        nop                                             ; 0053 _ 90\n" +
            "        leave                                           ; 0054 _ C9\n" +
            "        ret                                             ; 0055 _ C3\n" +
            "; println End of function\n" +
            "\n" +
            "printInt:; Function begin\n" +
            "        push    rbp                                     ; 0056 _ 55\n" +
            "        mov     rbp, rsp                                ; 0057 _ 48: 89. E5\n" +
            "        sub     rsp, 80                                 ; 005A _ 48: 83. EC, 50\n" +
            "        mov     dword [rbp-44H], edi                    ; 005E _ 89. 7D, BC\n" +
            "; Note: Address is not rip-relative\n" +
            "; Note: Absolute memory address without relocation\n" +
            "        mov     rax, qword [fs:abs 28H]                 ; 0061 _ 64 48: 8B. 04 25, 00000028\n" +
            "        mov     qword [rbp-8H], rax                     ; 006A _ 48: 89. 45, F8\n" +
            "        xor     eax, eax                                ; 006E _ 31. C0\n" +
            "        cmp     dword [rbp-44H], 0                      ; 0070 _ 83. 7D, BC, 00\n" +
            "        jnz     ?_001                                   ; 0074 _ 75, 0C\n" +
            "        mov     edi, 48                                 ; 0076 _ BF, 00000030\n" +
            "        call    putchar                                 ; 007B _ E8, 00000000(PLT r)\n" +
            "        jmp     ?_002                                   ; 0080 _ EB, 13\n" +
            "\n" +
            "?_001:  cmp     dword [rbp-44H], 0                      ; 0082 _ 83. 7D, BC, 00\n" +
            "        jns     ?_002                                   ; 0086 _ 79, 0D\n" +
            "        neg     dword [rbp-44H]                         ; 0088 _ F7. 5D, BC\n" +
            "        mov     edi, 45                                 ; 008B _ BF, 0000002D\n" +
            "        call    putchar                                 ; 0090 _ E8, 00000000(PLT r)\n" +
            "?_002:  mov     dword [rbp-38H], 0                      ; 0095 _ C7. 45, C8, 00000000\n" +
            "        jmp     ?_004                                   ; 009C _ EB, 4E\n" +
            "\n" +
            "?_003:  mov     esi, dword [rbp-38H]                    ; 009E _ 8B. 75, C8\n" +
            "        lea     eax, [rsi+1H]                           ; 00A1 _ 8D. 46, 01\n" +
            "        mov     dword [rbp-38H], eax                    ; 00A4 _ 89. 45, C8\n" +
            "        mov     ecx, dword [rbp-44H]                    ; 00A7 _ 8B. 4D, BC\n" +
            "        mov     edx, 1717986919                         ; 00AA _ BA, 66666667\n" +
            "        mov     eax, ecx                                ; 00AF _ 89. C8\n" +
            "        imul    edx                                     ; 00B1 _ F7. EA\n" +
            "        sar     edx, 2                                  ; 00B3 _ C1. FA, 02\n" +
            "        mov     eax, ecx                                ; 00B6 _ 89. C8\n" +
            "        sar     eax, 31                                 ; 00B8 _ C1. F8, 1F\n" +
            "        sub     edx, eax                                ; 00BB _ 29. C2\n" +
            "        mov     eax, edx                                ; 00BD _ 89. D0\n" +
            "        shl     eax, 2                                  ; 00BF _ C1. E0, 02\n" +
            "        add     eax, edx                                ; 00C2 _ 01. D0\n" +
            "        add     eax, eax                                ; 00C4 _ 01. C0\n" +
            "        sub     ecx, eax                                ; 00C6 _ 29. C1\n" +
            "        mov     edx, ecx                                ; 00C8 _ 89. CA\n" +
            "        movsxd  rax, esi                                ; 00CA _ 48: 63. C6\n" +
            "        mov     dword [rbp+rax*4-30H], edx              ; 00CD _ 89. 54 85, D0\n" +
            "        mov     ecx, dword [rbp-44H]                    ; 00D1 _ 8B. 4D, BC\n" +
            "        mov     edx, 1717986919                         ; 00D4 _ BA, 66666667\n" +
            "        mov     eax, ecx                                ; 00D9 _ 89. C8\n" +
            "        imul    edx                                     ; 00DB _ F7. EA\n" +
            "        sar     edx, 2                                  ; 00DD _ C1. FA, 02\n" +
            "        mov     eax, ecx                                ; 00E0 _ 89. C8\n" +
            "        sar     eax, 31                                 ; 00E2 _ C1. F8, 1F\n" +
            "        sub     edx, eax                                ; 00E5 _ 29. C2\n" +
            "        mov     eax, edx                                ; 00E7 _ 89. D0\n" +
            "        mov     dword [rbp-44H], eax                    ; 00E9 _ 89. 45, BC\n" +
            "?_004:  cmp     dword [rbp-44H], 0                      ; 00EC _ 83. 7D, BC, 00\n" +
            "        jg      ?_003                                   ; 00F0 _ 7F, AC\n" +
            "        mov     eax, dword [rbp-38H]                    ; 00F2 _ 8B. 45, C8\n" +
            "        sub     eax, 1                                  ; 00F5 _ 83. E8, 01\n" +
            "        mov     dword [rbp-34H], eax                    ; 00F8 _ 89. 45, CC\n" +
            "        jmp     ?_006                                   ; 00FB _ EB, 17\n" +
            "\n" +
            "?_005:  mov     eax, dword [rbp-34H]                    ; 00FD _ 8B. 45, CC\n" +
            "        cdqe                                            ; 0100 _ 48: 98\n" +
            "        mov     eax, dword [rbp+rax*4-30H]              ; 0102 _ 8B. 44 85, D0\n" +
            "        add     eax, 48                                 ; 0106 _ 83. C0, 30\n" +
            "        mov     edi, eax                                ; 0109 _ 89. C7\n" +
            "        call    putchar                                 ; 010B _ E8, 00000000(PLT r)\n" +
            "        sub     dword [rbp-34H], 1                      ; 0110 _ 83. 6D, CC, 01\n" +
            "?_006:  cmp     dword [rbp-34H], 0                      ; 0114 _ 83. 7D, CC, 00\n" +
            "        jns     ?_005                                   ; 0118 _ 79, E3\n" +
            "        nop                                             ; 011A _ 90\n" +
            "        mov     rax, qword [rbp-8H]                     ; 011B _ 48: 8B. 45, F8\n" +
            "; Note: Address is not rip-relative\n" +
            "; Note: Absolute memory address without relocation\n" +
            "        xor     rax, qword [fs:abs 28H]                 ; 011F _ 64 48: 33. 04 25, 00000028\n" +
            "        jz      ?_007                                   ; 0128 _ 74, 05\n" +
            "        call    __stack_chk_fail                        ; 012A _ E8, 00000000(PLT r)\n" +
            "?_007:  leave                                           ; 012F _ C9\n" +
            "        ret                                             ; 0130 _ C3\n" +
            "; printInt End of function\n" +
            "\n" +
            "printlnInt:; Function begin\n" +
            "        push    rbp                                     ; 0131 _ 55\n" +
            "        mov     rbp, rsp                                ; 0132 _ 48: 89. E5\n" +
            "        sub     rsp, 80                                 ; 0135 _ 48: 83. EC, 50\n" +
            "        mov     dword [rbp-44H], edi                    ; 0139 _ 89. 7D, BC\n" +
            "; Note: Address is not rip-relative\n" +
            "; Note: Absolute memory address without relocation\n" +
            "        mov     rax, qword [fs:abs 28H]                 ; 013C _ 64 48: 8B. 04 25, 00000028\n" +
            "        mov     qword [rbp-8H], rax                     ; 0145 _ 48: 89. 45, F8\n" +
            "        xor     eax, eax                                ; 0149 _ 31. C0\n" +
            "        cmp     dword [rbp-44H], 0                      ; 014B _ 83. 7D, BC, 00\n" +
            "        jnz     ?_008                                   ; 014F _ 75, 0C\n" +
            "        mov     edi, 48                                 ; 0151 _ BF, 00000030\n" +
            "        call    putchar                                 ; 0156 _ E8, 00000000(PLT r)\n" +
            "        jmp     ?_009                                   ; 015B _ EB, 13\n" +
            "\n" +
            "?_008:  cmp     dword [rbp-44H], 0                      ; 015D _ 83. 7D, BC, 00\n" +
            "        jns     ?_009                                   ; 0161 _ 79, 0D\n" +
            "        neg     dword [rbp-44H]                         ; 0163 _ F7. 5D, BC\n" +
            "        mov     edi, 45                                 ; 0166 _ BF, 0000002D\n" +
            "        call    putchar                                 ; 016B _ E8, 00000000(PLT r)\n" +
            "?_009:  mov     dword [rbp-38H], 0                      ; 0170 _ C7. 45, C8, 00000000\n" +
            "        jmp     ?_011                                   ; 0177 _ EB, 4E\n" +
            "\n" +
            "?_010:  mov     esi, dword [rbp-38H]                    ; 0179 _ 8B. 75, C8\n" +
            "        lea     eax, [rsi+1H]                           ; 017C _ 8D. 46, 01\n" +
            "        mov     dword [rbp-38H], eax                    ; 017F _ 89. 45, C8\n" +
            "        mov     ecx, dword [rbp-44H]                    ; 0182 _ 8B. 4D, BC\n" +
            "        mov     edx, 1717986919                         ; 0185 _ BA, 66666667\n" +
            "        mov     eax, ecx                                ; 018A _ 89. C8\n" +
            "        imul    edx                                     ; 018C _ F7. EA\n" +
            "        sar     edx, 2                                  ; 018E _ C1. FA, 02\n" +
            "        mov     eax, ecx                                ; 0191 _ 89. C8\n" +
            "        sar     eax, 31                                 ; 0193 _ C1. F8, 1F\n" +
            "        sub     edx, eax                                ; 0196 _ 29. C2\n" +
            "        mov     eax, edx                                ; 0198 _ 89. D0\n" +
            "        shl     eax, 2                                  ; 019A _ C1. E0, 02\n" +
            "        add     eax, edx                                ; 019D _ 01. D0\n" +
            "        add     eax, eax                                ; 019F _ 01. C0\n" +
            "        sub     ecx, eax                                ; 01A1 _ 29. C1\n" +
            "        mov     edx, ecx                                ; 01A3 _ 89. CA\n" +
            "        movsxd  rax, esi                                ; 01A5 _ 48: 63. C6\n" +
            "        mov     dword [rbp+rax*4-30H], edx              ; 01A8 _ 89. 54 85, D0\n" +
            "        mov     ecx, dword [rbp-44H]                    ; 01AC _ 8B. 4D, BC\n" +
            "        mov     edx, 1717986919                         ; 01AF _ BA, 66666667\n" +
            "        mov     eax, ecx                                ; 01B4 _ 89. C8\n" +
            "        imul    edx                                     ; 01B6 _ F7. EA\n" +
            "        sar     edx, 2                                  ; 01B8 _ C1. FA, 02\n" +
            "        mov     eax, ecx                                ; 01BB _ 89. C8\n" +
            "        sar     eax, 31                                 ; 01BD _ C1. F8, 1F\n" +
            "        sub     edx, eax                                ; 01C0 _ 29. C2\n" +
            "        mov     eax, edx                                ; 01C2 _ 89. D0\n" +
            "        mov     dword [rbp-44H], eax                    ; 01C4 _ 89. 45, BC\n" +
            "?_011:  cmp     dword [rbp-44H], 0                      ; 01C7 _ 83. 7D, BC, 00\n" +
            "        jg      ?_010                                   ; 01CB _ 7F, AC\n" +
            "        mov     eax, dword [rbp-38H]                    ; 01CD _ 8B. 45, C8\n" +
            "        sub     eax, 1                                  ; 01D0 _ 83. E8, 01\n" +
            "        mov     dword [rbp-34H], eax                    ; 01D3 _ 89. 45, CC\n" +
            "        jmp     ?_013                                   ; 01D6 _ EB, 17\n" +
            "\n" +
            "?_012:  mov     eax, dword [rbp-34H]                    ; 01D8 _ 8B. 45, CC\n" +
            "        cdqe                                            ; 01DB _ 48: 98\n" +
            "        mov     eax, dword [rbp+rax*4-30H]              ; 01DD _ 8B. 44 85, D0\n" +
            "        add     eax, 48                                 ; 01E1 _ 83. C0, 30\n" +
            "        mov     edi, eax                                ; 01E4 _ 89. C7\n" +
            "        call    putchar                                 ; 01E6 _ E8, 00000000(PLT r)\n" +
            "        sub     dword [rbp-34H], 1                      ; 01EB _ 83. 6D, CC, 01\n" +
            "?_013:  cmp     dword [rbp-34H], 0                      ; 01EF _ 83. 7D, CC, 00\n" +
            "        jns     ?_012                                   ; 01F3 _ 79, E3\n" +
            "        mov     edi, 10                                 ; 01F5 _ BF, 0000000A\n" +
            "        call    putchar                                 ; 01FA _ E8, 00000000(PLT r)\n" +
            "        nop                                             ; 01FF _ 90\n" +
            "        mov     rax, qword [rbp-8H]                     ; 0200 _ 48: 8B. 45, F8\n" +
            "; Note: Address is not rip-relative\n" +
            "; Note: Absolute memory address without relocation\n" +
            "        xor     rax, qword [fs:abs 28H]                 ; 0204 _ 64 48: 33. 04 25, 00000028\n" +
            "        jz      ?_014                                   ; 020D _ 74, 05\n" +
            "        call    __stack_chk_fail                        ; 020F _ E8, 00000000(PLT r)\n" +
            "?_014:  leave                                           ; 0214 _ C9\n" +
            "        ret                                             ; 0215 _ C3\n" +
            "; printlnInt End of function\n" +
            "\n" +
            "getString:; Function begin\n" +
            "        push    rbp                                     ; 0216 _ 55\n" +
            "        mov     rbp, rsp                                ; 0217 _ 48: 89. E5\n" +
            "        sub     rsp, 16                                 ; 021A _ 48: 83. EC, 10\n" +
            "        mov     edi, 266                                ; 021E _ BF, 0000010A\n" +
            "        call    malloc                                  ; 0223 _ E8, 00000000(PLT r)\n" +
            "        mov     qword [rbp-8H], rax                     ; 0228 _ 48: 89. 45, F8\n" +
            "        mov     eax, 8                                  ; 022C _ B8, 00000008\n" +
            "        mov     edx, eax                                ; 0231 _ 89. C2\n" +
            "        mov     rax, qword [rbp-8H]                     ; 0233 _ 48: 8B. 45, F8\n" +
            "        add     rax, rdx                                ; 0237 _ 48: 01. D0\n" +
            "        mov     rsi, rax                                ; 023A _ 48: 89. C6\n" +
            "        lea     rdi, [rel ?_054]                        ; 023D _ 48: 8D. 3D, 00000000(rel)\n" +
            "        mov     eax, 0                                  ; 0244 _ B8, 00000000\n" +
            "        call    __isoc99_scanf                          ; 0249 _ E8, 00000000(PLT r)\n" +
            "        mov     eax, 8                                  ; 024E _ B8, 00000008\n" +
            "        mov     edx, eax                                ; 0253 _ 89. C2\n" +
            "        mov     rax, qword [rbp-8H]                     ; 0255 _ 48: 8B. 45, F8\n" +
            "        add     rax, rdx                                ; 0259 _ 48: 01. D0\n" +
            "        mov     rdi, rax                                ; 025C _ 48: 89. C7\n" +
            "        call    strlen                                  ; 025F _ E8, 00000000(PLT r)\n" +
            "        mov     rdx, rax                                ; 0264 _ 48: 89. C2\n" +
            "        mov     rax, qword [rbp-8H]                     ; 0267 _ 48: 8B. 45, F8\n" +
            "        mov     qword [rax], rdx                        ; 026B _ 48: 89. 10\n" +
            "        mov     rax, qword [rbp-8H]                     ; 026E _ 48: 8B. 45, F8\n" +
            "        leave                                           ; 0272 _ C9\n" +
            "        ret                                             ; 0273 _ C3\n" +
            "; getString End of function\n" +
            "\n" +
            "getInt: ; Function begin\n" +
            "        push    rbp                                     ; 0274 _ 55\n" +
            "        mov     rbp, rsp                                ; 0275 _ 48: 89. E5\n" +
            "        sub     rsp, 16                                 ; 0278 _ 48: 83. EC, 10\n" +
            "        call    getchar                                 ; 027C _ E8, 00000000(PLT r)\n" +
            "        mov     byte [rbp-9H], al                       ; 0281 _ 88. 45, F7\n" +
            "        jmp     ?_016                                   ; 0284 _ EB, 08\n" +
            "\n" +
            "?_015:  call    getchar                                 ; 0286 _ E8, 00000000(PLT r)\n" +
            "        mov     byte [rbp-9H], al                       ; 028B _ 88. 45, F7\n" +
            "?_016:  cmp     byte [rbp-9H], 45                       ; 028E _ 80. 7D, F7, 2D\n" +
            "        jz      ?_017                                   ; 0292 _ 74, 0C\n" +
            "        cmp     byte [rbp-9H], 47                       ; 0294 _ 80. 7D, F7, 2F\n" +
            "        jle     ?_015                                   ; 0298 _ 7E, EC\n" +
            "        cmp     byte [rbp-9H], 57                       ; 029A _ 80. 7D, F7, 39\n" +
            "        jg      ?_015                                   ; 029E _ 7F, E6\n" +
            "?_017:  cmp     byte [rbp-9H], 45                       ; 02A0 _ 80. 7D, F7, 2D\n" +
            "        jnz     ?_018                                   ; 02A4 _ 75, 07\n" +
            "        mov     eax, 4294967295                         ; 02A6 _ B8, FFFFFFFF\n" +
            "        jmp     ?_019                                   ; 02AB _ EB, 05\n" +
            "\n" +
            "?_018:  mov     eax, 1                                  ; 02AD _ B8, 00000001\n" +
            "?_019:  mov     dword [rbp-4H], eax                     ; 02B2 _ 89. 45, FC\n" +
            "        cmp     byte [rbp-9H], 45                       ; 02B5 _ 80. 7D, F7, 2D\n" +
            "        jz      ?_020                                   ; 02B9 _ 74, 09\n" +
            "        movsx   eax, byte [rbp-9H]                      ; 02BB _ 0F BE. 45, F7\n" +
            "        sub     eax, 48                                 ; 02BF _ 83. E8, 30\n" +
            "        jmp     ?_021                                   ; 02C2 _ EB, 05\n" +
            "\n" +
            "?_020:  mov     eax, 0                                  ; 02C4 _ B8, 00000000\n" +
            "?_021:  mov     dword [rbp-8H], eax                     ; 02C9 _ 89. 45, F8\n" +
            "        jmp     ?_023                                   ; 02CC _ EB, 1A\n" +
            "\n" +
            "?_022:  mov     edx, dword [rbp-8H]                     ; 02CE _ 8B. 55, F8\n" +
            "        mov     eax, edx                                ; 02D1 _ 89. D0\n" +
            "        shl     eax, 2                                  ; 02D3 _ C1. E0, 02\n" +
            "        add     eax, edx                                ; 02D6 _ 01. D0\n" +
            "        add     eax, eax                                ; 02D8 _ 01. C0\n" +
            "        mov     edx, eax                                ; 02DA _ 89. C2\n" +
            "        movsx   eax, byte [rbp-9H]                      ; 02DC _ 0F BE. 45, F7\n" +
            "        add     eax, edx                                ; 02E0 _ 01. D0\n" +
            "        sub     eax, 48                                 ; 02E2 _ 83. E8, 30\n" +
            "        mov     dword [rbp-8H], eax                     ; 02E5 _ 89. 45, F8\n" +
            "?_023:  call    getchar                                 ; 02E8 _ E8, 00000000(PLT r)\n" +
            "        mov     byte [rbp-9H], al                       ; 02ED _ 88. 45, F7\n" +
            "        cmp     byte [rbp-9H], 47                       ; 02F0 _ 80. 7D, F7, 2F\n" +
            "        jle     ?_024                                   ; 02F4 _ 7E, 0D\n" +
            "        cmp     byte [rbp-9H], 57                       ; 02F6 _ 80. 7D, F7, 39\n" +
            "        jg      ?_024                                   ; 02FA _ 7F, 07\n" +
            "        mov     eax, 1                                  ; 02FC _ B8, 00000001\n" +
            "        jmp     ?_025                                   ; 0301 _ EB, 05\n" +
            "\n" +
            "?_024:  mov     eax, 0                                  ; 0303 _ B8, 00000000\n" +
            "?_025:  test    eax, eax                                ; 0308 _ 85. C0\n" +
            "        jnz     ?_022                                   ; 030A _ 75, C2\n" +
            "        mov     eax, dword [rbp-8H]                     ; 030C _ 8B. 45, F8\n" +
            "        imul    eax, dword [rbp-4H]                     ; 030F _ 0F AF. 45, FC\n" +
            "        mov     dword [rbp-8H], eax                     ; 0313 _ 89. 45, F8\n" +
            "        mov     eax, dword [rbp-8H]                     ; 0316 _ 8B. 45, F8\n" +
            "        leave                                           ; 0319 _ C9\n" +
            "        ret                                             ; 031A _ C3\n" +
            "; getInt End of function\n" +
            "\n" +
            "toString:; Function begin\n" +
            "        push    rbp                                     ; 031B _ 55\n" +
            "        mov     rbp, rsp                                ; 031C _ 48: 89. E5\n" +
            "        sub     rsp, 96                                 ; 031F _ 48: 83. EC, 60\n" +
            "        mov     dword [rbp-54H], edi                    ; 0323 _ 89. 7D, AC\n" +
            "; Note: Address is not rip-relative\n" +
            "; Note: Absolute memory address without relocation\n" +
            "        mov     rax, qword [fs:abs 28H]                 ; 0326 _ 64 48: 8B. 04 25, 00000028\n" +
            "        mov     qword [rbp-8H], rax                     ; 032F _ 48: 89. 45, F8\n" +
            "        xor     eax, eax                                ; 0333 _ 31. C0\n" +
            "        cmp     dword [rbp-54H], 0                      ; 0335 _ 83. 7D, AC, 00\n" +
            "        jns     ?_026                                   ; 0339 _ 79, 0C\n" +
            "        neg     dword [rbp-54H]                         ; 033B _ F7. 5D, AC\n" +
            "        mov     dword [rbp-44H], -1                     ; 033E _ C7. 45, BC, FFFFFFFF\n" +
            "        jmp     ?_027                                   ; 0345 _ EB, 07\n" +
            "\n" +
            "?_026:  mov     dword [rbp-44H], 0                      ; 0347 _ C7. 45, BC, 00000000\n" +
            "?_027:  mov     dword [rbp-40H], 0                      ; 034E _ C7. 45, C0, 00000000\n" +
            "        cmp     dword [rbp-54H], 0                      ; 0355 _ 83. 7D, AC, 00\n" +
            "        jnz     ?_029                                   ; 0359 _ 75, 63\n" +
            "        mov     eax, dword [rbp-40H]                    ; 035B _ 8B. 45, C0\n" +
            "        lea     edx, [rax+1H]                           ; 035E _ 8D. 50, 01\n" +
            "        mov     dword [rbp-40H], edx                    ; 0361 _ 89. 55, C0\n" +
            "        cdqe                                            ; 0364 _ 48: 98\n" +
            "        mov     dword [rbp+rax*4-30H], 0                ; 0366 _ C7. 44 85, D0, 00000000\n" +
            "        jmp     ?_030                                   ; 036E _ EB, 54\n" +
            "\n" +
            "?_028:  mov     esi, dword [rbp-40H]                    ; 0370 _ 8B. 75, C0\n" +
            "        lea     eax, [rsi+1H]                           ; 0373 _ 8D. 46, 01\n" +
            "        mov     dword [rbp-40H], eax                    ; 0376 _ 89. 45, C0\n" +
            "        mov     ecx, dword [rbp-54H]                    ; 0379 _ 8B. 4D, AC\n" +
            "        mov     edx, 1717986919                         ; 037C _ BA, 66666667\n" +
            "        mov     eax, ecx                                ; 0381 _ 89. C8\n" +
            "        imul    edx                                     ; 0383 _ F7. EA\n" +
            "        sar     edx, 2                                  ; 0385 _ C1. FA, 02\n" +
            "        mov     eax, ecx                                ; 0388 _ 89. C8\n" +
            "        sar     eax, 31                                 ; 038A _ C1. F8, 1F\n" +
            "        sub     edx, eax                                ; 038D _ 29. C2\n" +
            "        mov     eax, edx                                ; 038F _ 89. D0\n" +
            "        shl     eax, 2                                  ; 0391 _ C1. E0, 02\n" +
            "        add     eax, edx                                ; 0394 _ 01. D0\n" +
            "        add     eax, eax                                ; 0396 _ 01. C0\n" +
            "        sub     ecx, eax                                ; 0398 _ 29. C1\n" +
            "        mov     edx, ecx                                ; 039A _ 89. CA\n" +
            "        movsxd  rax, esi                                ; 039C _ 48: 63. C6\n" +
            "        mov     dword [rbp+rax*4-30H], edx              ; 039F _ 89. 54 85, D0\n" +
            "        mov     ecx, dword [rbp-54H]                    ; 03A3 _ 8B. 4D, AC\n" +
            "        mov     edx, 1717986919                         ; 03A6 _ BA, 66666667\n" +
            "        mov     eax, ecx                                ; 03AB _ 89. C8\n" +
            "        imul    edx                                     ; 03AD _ F7. EA\n" +
            "        sar     edx, 2                                  ; 03AF _ C1. FA, 02\n" +
            "        mov     eax, ecx                                ; 03B2 _ 89. C8\n" +
            "        sar     eax, 31                                 ; 03B4 _ C1. F8, 1F\n" +
            "        sub     edx, eax                                ; 03B7 _ 29. C2\n" +
            "        mov     eax, edx                                ; 03B9 _ 89. D0\n" +
            "        mov     dword [rbp-54H], eax                    ; 03BB _ 89. 45, AC\n" +
            "?_029:  cmp     dword [rbp-54H], 0                      ; 03BE _ 83. 7D, AC, 00\n" +
            "        jg      ?_028                                   ; 03C2 _ 7F, AC\n" +
            "?_030:  mov     edx, dword [rbp-44H]                    ; 03C4 _ 8B. 55, BC\n" +
            "        mov     eax, dword [rbp-40H]                    ; 03C7 _ 8B. 45, C0\n" +
            "        add     eax, edx                                ; 03CA _ 01. D0\n" +
            "        mov     edx, eax                                ; 03CC _ 89. C2\n" +
            "        mov     eax, 8                                  ; 03CE _ B8, 00000008\n" +
            "        add     eax, edx                                ; 03D3 _ 01. D0\n" +
            "        add     eax, 1                                  ; 03D5 _ 83. C0, 01\n" +
            "        mov     eax, eax                                ; 03D8 _ 89. C0\n" +
            "        mov     rdi, rax                                ; 03DA _ 48: 89. C7\n" +
            "        call    malloc                                  ; 03DD _ E8, 00000000(PLT r)\n" +
            "        mov     qword [rbp-38H], rax                    ; 03E2 _ 48: 89. 45, C8\n" +
            "        mov     edx, dword [rbp-44H]                    ; 03E6 _ 8B. 55, BC\n" +
            "        mov     eax, dword [rbp-40H]                    ; 03E9 _ 8B. 45, C0\n" +
            "        add     eax, edx                                ; 03EC _ 01. D0\n" +
            "        movsxd  rdx, eax                                ; 03EE _ 48: 63. D0\n" +
            "        mov     rax, qword [rbp-38H]                    ; 03F1 _ 48: 8B. 45, C8\n" +
            "        mov     qword [rax], rdx                        ; 03F5 _ 48: 89. 10\n" +
            "        mov     eax, 8                                  ; 03F8 _ B8, 00000008\n" +
            "        mov     eax, eax                                ; 03FD _ 89. C0\n" +
            "        add     qword [rbp-38H], rax                    ; 03FF _ 48: 01. 45, C8\n" +
            "        cmp     dword [rbp-44H], 0                      ; 0403 _ 83. 7D, BC, 00\n" +
            "        jz      ?_031                                   ; 0407 _ 74, 07\n" +
            "        mov     rax, qword [rbp-38H]                    ; 0409 _ 48: 8B. 45, C8\n" +
            "        mov     byte [rax], 45                          ; 040D _ C6. 00, 2D\n" +
            "?_031:  mov     dword [rbp-3CH], 0                      ; 0410 _ C7. 45, C4, 00000000\n" +
            "        jmp     ?_033                                   ; 0417 _ EB, 2C\n" +
            "\n" +
            "?_032:  mov     eax, dword [rbp-40H]                    ; 0419 _ 8B. 45, C0\n" +
            "        sub     eax, dword [rbp-3CH]                    ; 041C _ 2B. 45, C4\n" +
            "        sub     eax, 1                                  ; 041F _ 83. E8, 01\n" +
            "        cdqe                                            ; 0422 _ 48: 98\n" +
            "        mov     eax, dword [rbp+rax*4-30H]              ; 0424 _ 8B. 44 85, D0\n" +
            "        lea     ecx, [rax+30H]                          ; 0428 _ 8D. 48, 30\n" +
            "        mov     edx, dword [rbp-44H]                    ; 042B _ 8B. 55, BC\n" +
            "        mov     eax, dword [rbp-3CH]                    ; 042E _ 8B. 45, C4\n" +
            "        add     eax, edx                                ; 0431 _ 01. D0\n" +
            "        movsxd  rdx, eax                                ; 0433 _ 48: 63. D0\n" +
            "        mov     rax, qword [rbp-38H]                    ; 0436 _ 48: 8B. 45, C8\n" +
            "        add     rax, rdx                                ; 043A _ 48: 01. D0\n" +
            "        mov     edx, ecx                                ; 043D _ 89. CA\n" +
            "        mov     byte [rax], dl                          ; 043F _ 88. 10\n" +
            "        add     dword [rbp-3CH], 1                      ; 0441 _ 83. 45, C4, 01\n" +
            "?_033:  mov     eax, dword [rbp-3CH]                    ; 0445 _ 8B. 45, C4\n" +
            "        cmp     eax, dword [rbp-40H]                    ; 0448 _ 3B. 45, C0\n" +
            "        jl      ?_032                                   ; 044B _ 7C, CC\n" +
            "        mov     edx, dword [rbp-44H]                    ; 044D _ 8B. 55, BC\n" +
            "        mov     eax, dword [rbp-40H]                    ; 0450 _ 8B. 45, C0\n" +
            "        add     eax, edx                                ; 0453 _ 01. D0\n" +
            "        movsxd  rdx, eax                                ; 0455 _ 48: 63. D0\n" +
            "        mov     rax, qword [rbp-38H]                    ; 0458 _ 48: 8B. 45, C8\n" +
            "        add     rax, rdx                                ; 045C _ 48: 01. D0\n" +
            "        mov     byte [rax], 0                           ; 045F _ C6. 00, 00\n" +
            "        mov     eax, 8                                  ; 0462 _ B8, 00000008\n" +
            "        mov     eax, eax                                ; 0467 _ 89. C0\n" +
            "        neg     rax                                     ; 0469 _ 48: F7. D8\n" +
            "        mov     rdx, rax                                ; 046C _ 48: 89. C2\n" +
            "        mov     rax, qword [rbp-38H]                    ; 046F _ 48: 8B. 45, C8\n" +
            "        add     rax, rdx                                ; 0473 _ 48: 01. D0\n" +
            "        mov     rdi, qword [rbp-8H]                     ; 0476 _ 48: 8B. 7D, F8\n" +
            "; Note: Address is not rip-relative\n" +
            "; Note: Absolute memory address without relocation\n" +
            "        xor     rdi, qword [fs:abs 28H]                 ; 047A _ 64 48: 33. 3C 25, 00000028\n" +
            "        jz      ?_034                                   ; 0483 _ 74, 05\n" +
            "        call    __stack_chk_fail                        ; 0485 _ E8, 00000000(PLT r)\n" +
            "?_034:  leave                                           ; 048A _ C9\n" +
            "        ret                                             ; 048B _ C3\n" +
            "; toString End of function\n" +
            "\n" +
            "str_concat:; Function begin\n" +
            "        push    rbp                                     ; 048C _ 55\n" +
            "        mov     rbp, rsp                                ; 048D _ 48: 89. E5\n" +
            "        sub     rsp, 48                                 ; 0490 _ 48: 83. EC, 30\n" +
            "        mov     qword [rbp-28H], rdi                    ; 0494 _ 48: 89. 7D, D8\n" +
            "        mov     qword [rbp-30H], rsi                    ; 0498 _ 48: 89. 75, D0\n" +
            "        mov     rax, qword [rbp-28H]                    ; 049C _ 48: 8B. 45, D8\n" +
            "        mov     rax, qword [rax]                        ; 04A0 _ 48: 8B. 00\n" +
            "        mov     dword [rbp-14H], eax                    ; 04A3 _ 89. 45, EC\n" +
            "        mov     rax, qword [rbp-30H]                    ; 04A6 _ 48: 8B. 45, D0\n" +
            "        mov     rax, qword [rax]                        ; 04AA _ 48: 8B. 00\n" +
            "        mov     dword [rbp-10H], eax                    ; 04AD _ 89. 45, F0\n" +
            "        mov     edx, dword [rbp-14H]                    ; 04B0 _ 8B. 55, EC\n" +
            "        mov     eax, dword [rbp-10H]                    ; 04B3 _ 8B. 45, F0\n" +
            "        add     eax, edx                                ; 04B6 _ 01. D0\n" +
            "        mov     edx, eax                                ; 04B8 _ 89. C2\n" +
            "        mov     eax, 8                                  ; 04BA _ B8, 00000008\n" +
            "        add     eax, edx                                ; 04BF _ 01. D0\n" +
            "        add     eax, 1                                  ; 04C1 _ 83. C0, 01\n" +
            "        mov     eax, eax                                ; 04C4 _ 89. C0\n" +
            "        mov     rdi, rax                                ; 04C6 _ 48: 89. C7\n" +
            "        call    malloc                                  ; 04C9 _ E8, 00000000(PLT r)\n" +
            "        mov     qword [rbp-8H], rax                     ; 04CE _ 48: 89. 45, F8\n" +
            "        mov     edx, dword [rbp-14H]                    ; 04D2 _ 8B. 55, EC\n" +
            "        mov     eax, dword [rbp-10H]                    ; 04D5 _ 8B. 45, F0\n" +
            "        add     eax, edx                                ; 04D8 _ 01. D0\n" +
            "        movsxd  rdx, eax                                ; 04DA _ 48: 63. D0\n" +
            "        mov     rax, qword [rbp-8H]                     ; 04DD _ 48: 8B. 45, F8\n" +
            "        mov     qword [rax], rdx                        ; 04E1 _ 48: 89. 10\n" +
            "        mov     eax, 8                                  ; 04E4 _ B8, 00000008\n" +
            "        mov     eax, eax                                ; 04E9 _ 89. C0\n" +
            "        add     qword [rbp-28H], rax                    ; 04EB _ 48: 01. 45, D8\n" +
            "        mov     eax, 8                                  ; 04EF _ B8, 00000008\n" +
            "        mov     eax, eax                                ; 04F4 _ 89. C0\n" +
            "        add     qword [rbp-30H], rax                    ; 04F6 _ 48: 01. 45, D0\n" +
            "        mov     eax, 8                                  ; 04FA _ B8, 00000008\n" +
            "        mov     eax, eax                                ; 04FF _ 89. C0\n" +
            "        add     qword [rbp-8H], rax                     ; 0501 _ 48: 01. 45, F8\n" +
            "        mov     dword [rbp-0CH], 0                      ; 0505 _ C7. 45, F4, 00000000\n" +
            "        mov     dword [rbp-18H], 0                      ; 050C _ C7. 45, E8, 00000000\n" +
            "        jmp     ?_038                                   ; 0513 _ EB, 40\n" +
            "\n" +
            "?_035:  mov     eax, dword [rbp-18H]                    ; 0515 _ 8B. 45, E8\n" +
            "        cmp     eax, dword [rbp-14H]                    ; 0518 _ 3B. 45, EC\n" +
            "        jge     ?_036                                   ; 051B _ 7D, 12\n" +
            "        mov     eax, dword [rbp-18H]                    ; 051D _ 8B. 45, E8\n" +
            "        movsxd  rdx, eax                                ; 0520 _ 48: 63. D0\n" +
            "        mov     rax, qword [rbp-28H]                    ; 0523 _ 48: 8B. 45, D8\n" +
            "        add     rax, rdx                                ; 0527 _ 48: 01. D0\n" +
            "        movzx   eax, byte [rax]                         ; 052A _ 0F B6. 00\n" +
            "        jmp     ?_037                                   ; 052D _ EB, 13\n" +
            "\n" +
            "?_036:  mov     eax, dword [rbp-18H]                    ; 052F _ 8B. 45, E8\n" +
            "        sub     eax, dword [rbp-14H]                    ; 0532 _ 2B. 45, EC\n" +
            "        movsxd  rdx, eax                                ; 0535 _ 48: 63. D0\n" +
            "        mov     rax, qword [rbp-30H]                    ; 0538 _ 48: 8B. 45, D0\n" +
            "        add     rax, rdx                                ; 053C _ 48: 01. D0\n" +
            "        movzx   eax, byte [rax]                         ; 053F _ 0F B6. 00\n" +
            "?_037:  mov     edx, dword [rbp-18H]                    ; 0542 _ 8B. 55, E8\n" +
            "        movsxd  rcx, edx                                ; 0545 _ 48: 63. CA\n" +
            "        mov     rdx, qword [rbp-8H]                     ; 0548 _ 48: 8B. 55, F8\n" +
            "        add     rdx, rcx                                ; 054C _ 48: 01. CA\n" +
            "        mov     byte [rdx], al                          ; 054F _ 88. 02\n" +
            "        add     dword [rbp-18H], 1                      ; 0551 _ 83. 45, E8, 01\n" +
            "?_038:  mov     edx, dword [rbp-14H]                    ; 0555 _ 8B. 55, EC\n" +
            "        mov     eax, dword [rbp-10H]                    ; 0558 _ 8B. 45, F0\n" +
            "        add     eax, edx                                ; 055B _ 01. D0\n" +
            "        cmp     dword [rbp-18H], eax                    ; 055D _ 39. 45, E8\n" +
            "        jl      ?_035                                   ; 0560 _ 7C, B3\n" +
            "        mov     edx, dword [rbp-14H]                    ; 0562 _ 8B. 55, EC\n" +
            "        mov     eax, dword [rbp-10H]                    ; 0565 _ 8B. 45, F0\n" +
            "        add     eax, edx                                ; 0568 _ 01. D0\n" +
            "        movsxd  rdx, eax                                ; 056A _ 48: 63. D0\n" +
            "        mov     rax, qword [rbp-8H]                     ; 056D _ 48: 8B. 45, F8\n" +
            "        add     rax, rdx                                ; 0571 _ 48: 01. D0\n" +
            "        mov     byte [rax], 0                           ; 0574 _ C6. 00, 00\n" +
            "        mov     eax, 8                                  ; 0577 _ B8, 00000008\n" +
            "        mov     eax, eax                                ; 057C _ 89. C0\n" +
            "        neg     rax                                     ; 057E _ 48: F7. D8\n" +
            "        mov     rdx, rax                                ; 0581 _ 48: 89. C2\n" +
            "        mov     rax, qword [rbp-8H]                     ; 0584 _ 48: 8B. 45, F8\n" +
            "        add     rax, rdx                                ; 0588 _ 48: 01. D0\n" +
            "        leave                                           ; 058B _ C9\n" +
            "        ret                                             ; 058C _ C3\n" +
            "; str_concat End of function\n" +
            "\n" +
            "str_equal:; Function begin\n" +
            "        push    rbp                                     ; 058D _ 55\n" +
            "        mov     rbp, rsp                                ; 058E _ 48: 89. E5\n" +
            "        sub     rsp, 16                                 ; 0591 _ 48: 83. EC, 10\n" +
            "        mov     qword [rbp-8H], rdi                     ; 0595 _ 48: 89. 7D, F8\n" +
            "        mov     qword [rbp-10H], rsi                    ; 0599 _ 48: 89. 75, F0\n" +
            "        mov     eax, 8                                  ; 059D _ B8, 00000008\n" +
            "        mov     edx, eax                                ; 05A2 _ 89. C2\n" +
            "        mov     rax, qword [rbp-10H]                    ; 05A4 _ 48: 8B. 45, F0\n" +
            "        add     rdx, rax                                ; 05A8 _ 48: 01. C2\n" +
            "        mov     eax, 8                                  ; 05AB _ B8, 00000008\n" +
            "        mov     ecx, eax                                ; 05B0 _ 89. C1\n" +
            "        mov     rax, qword [rbp-8H]                     ; 05B2 _ 48: 8B. 45, F8\n" +
            "        add     rax, rcx                                ; 05B6 _ 48: 01. C8\n" +
            "        mov     rsi, rdx                                ; 05B9 _ 48: 89. D6\n" +
            "        mov     rdi, rax                                ; 05BC _ 48: 89. C7\n" +
            "        call    strcmp                                  ; 05BF _ E8, 00000000(PLT r)\n" +
            "        test    eax, eax                                ; 05C4 _ 85. C0\n" +
            "        sete    al                                      ; 05C6 _ 0F 94. C0\n" +
            "        movzx   eax, al                                 ; 05C9 _ 0F B6. C0\n" +
            "        leave                                           ; 05CC _ C9\n" +
            "        ret                                             ; 05CD _ C3\n" +
            "; str_equal End of function\n" +
            "\n" +
            "str_not_equal:; Function begin\n" +
            "        push    rbp                                     ; 05CE _ 55\n" +
            "        mov     rbp, rsp                                ; 05CF _ 48: 89. E5\n" +
            "        sub     rsp, 16                                 ; 05D2 _ 48: 83. EC, 10\n" +
            "        mov     qword [rbp-8H], rdi                     ; 05D6 _ 48: 89. 7D, F8\n" +
            "        mov     qword [rbp-10H], rsi                    ; 05DA _ 48: 89. 75, F0\n" +
            "        mov     eax, 8                                  ; 05DE _ B8, 00000008\n" +
            "        mov     edx, eax                                ; 05E3 _ 89. C2\n" +
            "        mov     rax, qword [rbp-10H]                    ; 05E5 _ 48: 8B. 45, F0\n" +
            "        add     rdx, rax                                ; 05E9 _ 48: 01. C2\n" +
            "        mov     eax, 8                                  ; 05EC _ B8, 00000008\n" +
            "        mov     ecx, eax                                ; 05F1 _ 89. C1\n" +
            "        mov     rax, qword [rbp-8H]                     ; 05F3 _ 48: 8B. 45, F8\n" +
            "        add     rax, rcx                                ; 05F7 _ 48: 01. C8\n" +
            "        mov     rsi, rdx                                ; 05FA _ 48: 89. D6\n" +
            "        mov     rdi, rax                                ; 05FD _ 48: 89. C7\n" +
            "        call    strcmp                                  ; 0600 _ E8, 00000000(PLT r)\n" +
            "        test    eax, eax                                ; 0605 _ 85. C0\n" +
            "        setne   al                                      ; 0607 _ 0F 95. C0\n" +
            "        movzx   eax, al                                 ; 060A _ 0F B6. C0\n" +
            "        leave                                           ; 060D _ C9\n" +
            "        ret                                             ; 060E _ C3\n" +
            "; str_not_equal End of function\n" +
            "\n" +
            "str_less:; Function begin\n" +
            "        push    rbp                                     ; 060F _ 55\n" +
            "        mov     rbp, rsp                                ; 0610 _ 48: 89. E5\n" +
            "        sub     rsp, 16                                 ; 0613 _ 48: 83. EC, 10\n" +
            "        mov     qword [rbp-8H], rdi                     ; 0617 _ 48: 89. 7D, F8\n" +
            "        mov     qword [rbp-10H], rsi                    ; 061B _ 48: 89. 75, F0\n" +
            "        mov     eax, 8                                  ; 061F _ B8, 00000008\n" +
            "        mov     edx, eax                                ; 0624 _ 89. C2\n" +
            "        mov     rax, qword [rbp-10H]                    ; 0626 _ 48: 8B. 45, F0\n" +
            "        add     rdx, rax                                ; 062A _ 48: 01. C2\n" +
            "        mov     eax, 8                                  ; 062D _ B8, 00000008\n" +
            "        mov     ecx, eax                                ; 0632 _ 89. C1\n" +
            "        mov     rax, qword [rbp-8H]                     ; 0634 _ 48: 8B. 45, F8\n" +
            "        add     rax, rcx                                ; 0638 _ 48: 01. C8\n" +
            "        mov     rsi, rdx                                ; 063B _ 48: 89. D6\n" +
            "        mov     rdi, rax                                ; 063E _ 48: 89. C7\n" +
            "        call    strcmp                                  ; 0641 _ E8, 00000000(PLT r)\n" +
            "        shr     eax, 31                                 ; 0646 _ C1. E8, 1F\n" +
            "        leave                                           ; 0649 _ C9\n" +
            "        ret                                             ; 064A _ C3\n" +
            "; str_less End of function\n" +
            "\n" +
            "str_lte:; Function begin\n" +
            "        push    rbp                                     ; 064B _ 55\n" +
            "        mov     rbp, rsp                                ; 064C _ 48: 89. E5\n" +
            "        sub     rsp, 16                                 ; 064F _ 48: 83. EC, 10\n" +
            "        mov     qword [rbp-8H], rdi                     ; 0653 _ 48: 89. 7D, F8\n" +
            "        mov     qword [rbp-10H], rsi                    ; 0657 _ 48: 89. 75, F0\n" +
            "        mov     eax, 8                                  ; 065B _ B8, 00000008\n" +
            "        mov     edx, eax                                ; 0660 _ 89. C2\n" +
            "        mov     rax, qword [rbp-10H]                    ; 0662 _ 48: 8B. 45, F0\n" +
            "        add     rdx, rax                                ; 0666 _ 48: 01. C2\n" +
            "        mov     eax, 8                                  ; 0669 _ B8, 00000008\n" +
            "        mov     ecx, eax                                ; 066E _ 89. C1\n" +
            "        mov     rax, qword [rbp-8H]                     ; 0670 _ 48: 8B. 45, F8\n" +
            "        add     rax, rcx                                ; 0674 _ 48: 01. C8\n" +
            "        mov     rsi, rdx                                ; 0677 _ 48: 89. D6\n" +
            "        mov     rdi, rax                                ; 067A _ 48: 89. C7\n" +
            "        call    strcmp                                  ; 067D _ E8, 00000000(PLT r)\n" +
            "        test    eax, eax                                ; 0682 _ 85. C0\n" +
            "        setle   al                                      ; 0684 _ 0F 9E. C0\n" +
            "        movzx   eax, al                                 ; 0687 _ 0F B6. C0\n" +
            "        leave                                           ; 068A _ C9\n" +
            "        ret                                             ; 068B _ C3\n" +
            "; str_lte End of function\n" +
            "\n" +
            "parseInt:; Function begin\n" +
            "        push    rbp                                     ; 068C _ 55\n" +
            "        mov     rbp, rsp                                ; 068D _ 48: 89. E5\n" +
            "        mov     qword [rbp-18H], rdi                    ; 0690 _ 48: 89. 7D, E8\n" +
            "        mov     eax, 8                                  ; 0694 _ B8, 00000008\n" +
            "        mov     eax, eax                                ; 0699 _ 89. C0\n" +
            "        add     qword [rbp-18H], rax                    ; 069B _ 48: 01. 45, E8\n" +
            "        mov     dword [rbp-8H], 0                       ; 069F _ C7. 45, F8, 00000000\n" +
            "        mov     eax, dword [rbp-8H]                     ; 06A6 _ 8B. 45, F8\n" +
            "        lea     edx, [rax+1H]                           ; 06A9 _ 8D. 50, 01\n" +
            "        mov     dword [rbp-8H], edx                     ; 06AC _ 89. 55, F8\n" +
            "        movsxd  rdx, eax                                ; 06AF _ 48: 63. D0\n" +
            "        mov     rax, qword [rbp-18H]                    ; 06B2 _ 48: 8B. 45, E8\n" +
            "        add     rax, rdx                                ; 06B6 _ 48: 01. D0\n" +
            "        movzx   eax, byte [rax]                         ; 06B9 _ 0F B6. 00\n" +
            "        mov     byte [rbp-0DH], al                      ; 06BC _ 88. 45, F3\n" +
            "        jmp     ?_040                                   ; 06BF _ EB, 19\n" +
            "\n" +
            "?_039:  mov     eax, dword [rbp-8H]                     ; 06C1 _ 8B. 45, F8\n" +
            "        lea     edx, [rax+1H]                           ; 06C4 _ 8D. 50, 01\n" +
            "        mov     dword [rbp-8H], edx                     ; 06C7 _ 89. 55, F8\n" +
            "        movsxd  rdx, eax                                ; 06CA _ 48: 63. D0\n" +
            "        mov     rax, qword [rbp-18H]                    ; 06CD _ 48: 8B. 45, E8\n" +
            "        add     rax, rdx                                ; 06D1 _ 48: 01. D0\n" +
            "        movzx   eax, byte [rax]                         ; 06D4 _ 0F B6. 00\n" +
            "        mov     byte [rbp-0DH], al                      ; 06D7 _ 88. 45, F3\n" +
            "?_040:  cmp     byte [rbp-0DH], 45                      ; 06DA _ 80. 7D, F3, 2D\n" +
            "        jz      ?_041                                   ; 06DE _ 74, 0C\n" +
            "        cmp     byte [rbp-0DH], 47                      ; 06E0 _ 80. 7D, F3, 2F\n" +
            "        jle     ?_039                                   ; 06E4 _ 7E, DB\n" +
            "        cmp     byte [rbp-0DH], 57                      ; 06E6 _ 80. 7D, F3, 39\n" +
            "        jg      ?_039                                   ; 06EA _ 7F, D5\n" +
            "?_041:  cmp     byte [rbp-0DH], 45                      ; 06EC _ 80. 7D, F3, 2D\n" +
            "        jnz     ?_042                                   ; 06F0 _ 75, 07\n" +
            "        mov     eax, 4294967295                         ; 06F2 _ B8, FFFFFFFF\n" +
            "        jmp     ?_043                                   ; 06F7 _ EB, 05\n" +
            "\n" +
            "?_042:  mov     eax, 1                                  ; 06F9 _ B8, 00000001\n" +
            "?_043:  mov     dword [rbp-4H], eax                     ; 06FE _ 89. 45, FC\n" +
            "        cmp     byte [rbp-0DH], 45                      ; 0701 _ 80. 7D, F3, 2D\n" +
            "        jz      ?_044                                   ; 0705 _ 74, 09\n" +
            "        movsx   eax, byte [rbp-0DH]                     ; 0707 _ 0F BE. 45, F3\n" +
            "        sub     eax, 48                                 ; 070B _ 83. E8, 30\n" +
            "        jmp     ?_045                                   ; 070E _ EB, 05\n" +
            "\n" +
            "?_044:  mov     eax, 0                                  ; 0710 _ B8, 00000000\n" +
            "?_045:  mov     dword [rbp-0CH], eax                    ; 0715 _ 89. 45, F4\n" +
            "        jmp     ?_047                                   ; 0718 _ EB, 1A\n" +
            "\n" +
            "?_046:  mov     edx, dword [rbp-0CH]                    ; 071A _ 8B. 55, F4\n" +
            "        mov     eax, edx                                ; 071D _ 89. D0\n" +
            "        shl     eax, 2                                  ; 071F _ C1. E0, 02\n" +
            "        add     eax, edx                                ; 0722 _ 01. D0\n" +
            "        add     eax, eax                                ; 0724 _ 01. C0\n" +
            "        mov     edx, eax                                ; 0726 _ 89. C2\n" +
            "        movsx   eax, byte [rbp-0DH]                     ; 0728 _ 0F BE. 45, F3\n" +
            "        add     eax, edx                                ; 072C _ 01. D0\n" +
            "        sub     eax, 48                                 ; 072E _ 83. E8, 30\n" +
            "        mov     dword [rbp-0CH], eax                    ; 0731 _ 89. 45, F4\n" +
            "?_047:  mov     eax, dword [rbp-8H]                     ; 0734 _ 8B. 45, F8\n" +
            "        lea     edx, [rax+1H]                           ; 0737 _ 8D. 50, 01\n" +
            "        mov     dword [rbp-8H], edx                     ; 073A _ 89. 55, F8\n" +
            "        movsxd  rdx, eax                                ; 073D _ 48: 63. D0\n" +
            "        mov     rax, qword [rbp-18H]                    ; 0740 _ 48: 8B. 45, E8\n" +
            "        add     rax, rdx                                ; 0744 _ 48: 01. D0\n" +
            "        movzx   eax, byte [rax]                         ; 0747 _ 0F B6. 00\n" +
            "        mov     byte [rbp-0DH], al                      ; 074A _ 88. 45, F3\n" +
            "        cmp     byte [rbp-0DH], 47                      ; 074D _ 80. 7D, F3, 2F\n" +
            "        jle     ?_048                                   ; 0751 _ 7E, 0D\n" +
            "        cmp     byte [rbp-0DH], 57                      ; 0753 _ 80. 7D, F3, 39\n" +
            "        jg      ?_048                                   ; 0757 _ 7F, 07\n" +
            "        mov     eax, 1                                  ; 0759 _ B8, 00000001\n" +
            "        jmp     ?_049                                   ; 075E _ EB, 05\n" +
            "\n" +
            "?_048:  mov     eax, 0                                  ; 0760 _ B8, 00000000\n" +
            "?_049:  test    eax, eax                                ; 0765 _ 85. C0\n" +
            "        jnz     ?_046                                   ; 0767 _ 75, B1\n" +
            "        cmp     dword [rbp-4H], 0                       ; 0769 _ 83. 7D, FC, 00\n" +
            "        jg      ?_050                                   ; 076D _ 7F, 07\n" +
            "        mov     eax, dword [rbp-0CH]                    ; 076F _ 8B. 45, F4\n" +
            "        neg     eax                                     ; 0772 _ F7. D8\n" +
            "        jmp     ?_051                                   ; 0774 _ EB, 03\n" +
            "\n" +
            "?_050:  mov     eax, dword [rbp-0CH]                    ; 0776 _ 8B. 45, F4\n" +
            "?_051:  pop     rbp                                     ; 0779 _ 5D\n" +
            "        ret                                             ; 077A _ C3\n" +
            "; parseInt End of function\n" +
            "\n" +
            "ord:    ; Function begin\n" +
            "        push    rbp                                     ; 077B _ 55\n" +
            "        mov     rbp, rsp                                ; 077C _ 48: 89. E5\n" +
            "        mov     qword [rbp-8H], rdi                     ; 077F _ 48: 89. 7D, F8\n" +
            "        mov     dword [rbp-0CH], esi                    ; 0783 _ 89. 75, F4\n" +
            "        mov     eax, dword [rbp-0CH]                    ; 0786 _ 8B. 45, F4\n" +
            "        mov     edx, 8                                  ; 0789 _ BA, 00000008\n" +
            "        add     eax, edx                                ; 078E _ 01. D0\n" +
            "        mov     edx, eax                                ; 0790 _ 89. C2\n" +
            "        mov     rax, qword [rbp-8H]                     ; 0792 _ 48: 8B. 45, F8\n" +
            "        add     rax, rdx                                ; 0796 _ 48: 01. D0\n" +
            "        movzx   eax, byte [rax]                         ; 0799 _ 0F B6. 00\n" +
            "        movsx   eax, al                                 ; 079C _ 0F BE. C0\n" +
            "        pop     rbp                                     ; 079F _ 5D\n" +
            "        ret                                             ; 07A0 _ C3\n" +
            "; ord End of function\n" +
            "\n" +
            "substring:; Function begin\n" +
            "        push    rbp                                     ; 07A1 _ 55\n" +
            "        mov     rbp, rsp                                ; 07A2 _ 48: 89. E5\n" +
            "        sub     rsp, 32                                 ; 07A5 _ 48: 83. EC, 20\n" +
            "        mov     qword [rbp-18H], rdi                    ; 07A9 _ 48: 89. 7D, E8\n" +
            "        mov     dword [rbp-1CH], esi                    ; 07AD _ 89. 75, E4\n" +
            "        mov     dword [rbp-20H], edx                    ; 07B0 _ 89. 55, E0\n" +
            "        mov     eax, dword [rbp-20H]                    ; 07B3 _ 8B. 45, E0\n" +
            "        sub     eax, dword [rbp-1CH]                    ; 07B6 _ 2B. 45, E4\n" +
            "        add     eax, 1                                  ; 07B9 _ 83. C0, 01\n" +
            "        mov     dword [rbp-0CH], eax                    ; 07BC _ 89. 45, F4\n" +
            "        mov     eax, dword [rbp-0CH]                    ; 07BF _ 8B. 45, F4\n" +
            "        mov     edx, 8                                  ; 07C2 _ BA, 00000008\n" +
            "        add     eax, edx                                ; 07C7 _ 01. D0\n" +
            "        add     eax, 1                                  ; 07C9 _ 83. C0, 01\n" +
            "        mov     eax, eax                                ; 07CC _ 89. C0\n" +
            "        mov     rdi, rax                                ; 07CE _ 48: 89. C7\n" +
            "        call    malloc                                  ; 07D1 _ E8, 00000000(PLT r)\n" +
            "        mov     qword [rbp-8H], rax                     ; 07D6 _ 48: 89. 45, F8\n" +
            "        mov     eax, dword [rbp-0CH]                    ; 07DA _ 8B. 45, F4\n" +
            "        movsxd  rdx, eax                                ; 07DD _ 48: 63. D0\n" +
            "        mov     rax, qword [rbp-8H]                     ; 07E0 _ 48: 8B. 45, F8\n" +
            "        mov     qword [rax], rdx                        ; 07E4 _ 48: 89. 10\n" +
            "        mov     eax, dword [rbp-1CH]                    ; 07E7 _ 8B. 45, E4\n" +
            "        mov     edx, 8                                  ; 07EA _ BA, 00000008\n" +
            "        add     eax, edx                                ; 07EF _ 01. D0\n" +
            "        mov     eax, eax                                ; 07F1 _ 89. C0\n" +
            "        add     qword [rbp-18H], rax                    ; 07F3 _ 48: 01. 45, E8\n" +
            "        mov     eax, 8                                  ; 07F7 _ B8, 00000008\n" +
            "        mov     eax, eax                                ; 07FC _ 89. C0\n" +
            "        add     qword [rbp-8H], rax                     ; 07FE _ 48: 01. 45, F8\n" +
            "        mov     dword [rbp-10H], 0                      ; 0802 _ C7. 45, F0, 00000000\n" +
            "        jmp     ?_053                                   ; 0809 _ EB, 23\n" +
            "\n" +
            "?_052:  mov     eax, dword [rbp-10H]                    ; 080B _ 8B. 45, F0\n" +
            "        movsxd  rdx, eax                                ; 080E _ 48: 63. D0\n" +
            "        mov     rax, qword [rbp-18H]                    ; 0811 _ 48: 8B. 45, E8\n" +
            "        add     rax, rdx                                ; 0815 _ 48: 01. D0\n" +
            "        mov     edx, dword [rbp-10H]                    ; 0818 _ 8B. 55, F0\n" +
            "        movsxd  rcx, edx                                ; 081B _ 48: 63. CA\n" +
            "        mov     rdx, qword [rbp-8H]                     ; 081E _ 48: 8B. 55, F8\n" +
            "        add     rdx, rcx                                ; 0822 _ 48: 01. CA\n" +
            "        movzx   eax, byte [rax]                         ; 0825 _ 0F B6. 00\n" +
            "        mov     byte [rdx], al                          ; 0828 _ 88. 02\n" +
            "        add     dword [rbp-10H], 1                      ; 082A _ 83. 45, F0, 01\n" +
            "?_053:  mov     eax, dword [rbp-10H]                    ; 082E _ 8B. 45, F0\n" +
            "        cmp     eax, dword [rbp-0CH]                    ; 0831 _ 3B. 45, F4\n" +
            "        jl      ?_052                                   ; 0834 _ 7C, D5\n" +
            "        mov     eax, dword [rbp-0CH]                    ; 0836 _ 8B. 45, F4\n" +
            "        movsxd  rdx, eax                                ; 0839 _ 48: 63. D0\n" +
            "        mov     rax, qword [rbp-8H]                     ; 083C _ 48: 8B. 45, F8\n" +
            "        add     rax, rdx                                ; 0840 _ 48: 01. D0\n" +
            "        mov     byte [rax], 0                           ; 0843 _ C6. 00, 00\n" +
            "        mov     eax, 8                                  ; 0846 _ B8, 00000008\n" +
            "        mov     eax, eax                                ; 084B _ 89. C0\n" +
            "        neg     rax                                     ; 084D _ 48: F7. D8\n" +
            "        mov     rdx, rax                                ; 0850 _ 48: 89. C2\n" +
            "        mov     rax, qword [rbp-8H]                     ; 0853 _ 48: 8B. 45, F8\n" +
            "        add     rax, rdx                                ; 0857 _ 48: 01. D0\n" +
            "        leave                                           ; 085A _ C9\n" +
            "        ret                                             ; 085B _ C3\n" +
            "; substring End of function";
    public String ed = "SECTION .bss    align=1 noexecute                       ; section number 3, bss\n" +
            "\n" +
            "\n" +
            "SECTION .rodata align=4 noexecute                       ; section number 4, const\n" +
            "\n" +
            "REG_SIZE:                                               ; dword\n" +
            "        dd 00000008H                                    ; 0000 _ 8 \n" +
            "\n" +
            "?_054:                                                  ; byte\n" +
            "        db 25H, 73H, 00H                                ; 0004 _ %s.";
}