package com.mm_cinema.common_library.csv;

import com.mm_cinema.common_library.csv.anotation.CsvColumn;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@SuperBuilder
@Getter
@Setter
public class BaseCsv {
    @CsvColumn(columnName = "Id")
    private Long id;
}
