package com.wurain.gridcolumninfo.repository.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.wurain.gridcolumninfo.model.Gridcolumninfo;
import com.wurain.gridcolumninfo.repository.GridcolumninfoRepository;

@Repository
public class GridcolumninfoRepositoryImpl implements GridcolumninfoRepository {

    @Autowired
    private JdbcTemplate jdbctemplate;

    @Override
    public void updateColKey(String pgmId) {
        StringBuffer str = new StringBuffer();

        str.append(" UPDATE gridcolumninfo A                     ");
        str.append(" SET column_key = B.column_key               ");
        str.append(" FROM(                                       ");
        str.append("     SELECT DISTINCT ON(B1.column_title)     ");
        str.append("            B1.column_title                  ");
        str.append("          , B1.column_key                    ");
        str.append("          , count(*) AS cnt                  ");
        str.append("     FROM   gridcolumninfo B1                ");
        str.append("     WHERE B1.column_key IS NOT NULL         ");
        str.append("       AND TRIM(B1.column_key) <> ''         ");
        str.append("       AND B1.pgm_id = ?                     ");
        str.append("     GROUP BY B1.column_title, B1.column_key ");
        str.append("     ORDER BY B1.column_title, cnt DESC      ");
        str.append(" ) AS B                                      ");
        str.append(" WHERE B.column_title = A.column_title       ");
        str.append("   AND A.pgm_id = ?                          ");
        str.append("   AND (A.column_key IS NULL OR              ");
        str.append("        TRIM(A.column_key) = '')             ");
        str.append(" ;                                           ");

        jdbctemplate.update(str.toString(), pgmId, pgmId);
    }

    @Override
    public void updateColType(String pgmId) {
        StringBuffer str = new StringBuffer();

        str.append(" UPDATE gridcolumninfo A                     ");
        str.append(" SET column_type = B.column_type             ");
        str.append(" FROM(                                       ");
        str.append("     SELECT DISTINCT ON(B1.column_title)     ");
        str.append("            B1.column_title                  ");
        str.append("          , B1.column_type                   ");
        str.append("          , count(*) AS cnt                  ");
        str.append("     FROM   gridcolumninfo B1                ");
        str.append("     WHERE B1.column_type IS NOT NULL        ");
        str.append("       AND TRIM(B1.column_type) <> ''        ");
        str.append("       AND B1.pgm_id = ?                     ");
        str.append("     GROUP BY B1.column_title                ");
        str.append("            , B1.column_type                 ");
        str.append("     ORDER BY B1.column_title, cnt DESC      ");
        str.append(" ) AS B                                      ");
        str.append(" WHERE B.column_title = A.column_title       ");
        str.append("   AND A.pgm_id = ?                          ");
        str.append("   AND (A.column_type IS NULL OR             ");
        str.append("        TRIM(A.column_type) = '')            ");
        str.append(" ;                                           ");

        jdbctemplate.update(str.toString(), pgmId, pgmId);
    }

    @Override
    public void updateColAlign(String pgmId) {
        StringBuffer str = new StringBuffer();

        str.append(" UPDATE gridcolumninfo A                     ");
        str.append(" SET column_align = B.column_align           ");
        str.append(" FROM(                                       ");
        str.append("     SELECT DISTINCT ON(B1.column_title)     ");
        str.append("            B1.column_title                  ");
        str.append("          , B1.column_align                  ");
        str.append("          , count(*) AS cnt                  ");
        str.append("     FROM   gridcolumninfo B1                ");
        str.append("     WHERE B1.column_align IS NOT NULL       ");
        str.append("       AND TRIM(B1.column_align) <> ''       ");
        str.append("       AND B1.pgm_id = ?                     ");
        str.append("     GROUP BY B1.column_title                ");
        str.append("            , B1.column_align                ");
        str.append("     ORDER BY B1.column_title, cnt DESC      ");
        str.append(" ) AS B                                      ");
        str.append(" WHERE B.column_title = A.column_title       ");
        str.append("   AND A.pgm_id = ?                          ");
        str.append("   AND (A.column_align IS NULL OR            ");
        str.append("        TRIM(A.column_align) = '')           ");
        str.append(" ;                                           ");

        jdbctemplate.update(str.toString(), pgmId, pgmId);
    }

    @Override
    public void updateColLength(String pgmId) {
        StringBuffer str = new StringBuffer();

        str.append(" UPDATE gridcolumninfo A                     ");
        str.append(" SET column_length = B.column_length         ");
        str.append(" FROM(                                       ");
        str.append("     SELECT DISTINCT ON(B1.column_title)     ");
        str.append("            B1.column_title                  ");
        str.append("          , B1.column_length                 ");
        str.append("          , count(*) AS cnt                  ");
        str.append("     FROM   gridcolumninfo B1                ");
        str.append("     WHERE B1.column_length IS NOT NULL      ");
        str.append("       AND B1.pgm_id = ?                     ");
        str.append("     GROUP BY B1.column_title                ");
        str.append("            , B1.column_length               ");
        str.append("     ORDER BY B1.column_title                ");
        str.append("            , cnt DESC                       ");
        str.append("            , B1.column_length ASC           ");
        str.append(" ) AS B                                      ");
        str.append(" WHERE B.column_title = A.column_title       ");
        str.append("   AND A.pgm_id = ?                          ");
        str.append("   AND A.column_length IS NULL               ");
        str.append(" ;                                           ");

        jdbctemplate.update(str.toString(), pgmId, pgmId);
    }

    @Override
    public void updateColKeyFromRes(String pgmId) {
        StringBuffer str = new StringBuffer();

        str.append(" UPDATE gridcolumninfo A                                ");
        str.append(" SET    column_key = B.key                              ");
        str.append(" FROM   (                                               ");
        str.append("     SELECT B1.key, B1.message                          ");
        str.append("     FROM   pjmessageresource_ja        B1              ");
        str.append("     UNION ALL                                          ");
        str.append("     SELECT B2.key, B2.message                          ");
        str.append("     FROM   yna2pymacmessageresource_ja B2              ");
        str.append(" ) AS B                                                 ");
        str.append(" WHERE(A.column_key IS NULL OR TRIM(A.column_key) = '') ");
        str.append("   AND A.column_title = B.message                       ");
        str.append("   AND A.pgm_id = ?                                     ");
        str.append(" ;                                                      ");

        jdbctemplate.update(str.toString(), pgmId);
    }

    @Override
    public List<Gridcolumninfo> findByPgmId(String pgmId) {
        StringBuffer str = new StringBuffer();

        str.append(" SELECT *              ");
        str.append(" FROM   gridcolumninfo ");
        str.append(" WHERE  pgm_id = ?     ");
        str.append(" ORDER BY 1,2,3        ");

        Object[] params = new Object[] { pgmId };

        return jdbctemplate.query(str.toString(), params, new BeanPropertyRowMapper<>(Gridcolumninfo.class));
    }

    @Override
    public void insert(Gridcolumninfo gridcolumninfo) {
        StringBuffer str = new StringBuffer();

        str.append(" INSERT INTO                                            ");
        str.append("     gridcolumninfo (                                   ");
        str.append("           pgm_id                                       ");
        str.append("         , column_id                                    ");
        str.append("         , column_title                                 ");
        str.append("         , column_key                                   ");
        str.append("         , column_type                                  ");
        str.append("         , column_align                                 ");
        str.append("         , column_length                                ");
        str.append(" )                                                      ");
        str.append(" VALUES(                                                ");
        str.append("       ?                                                ");
        str.append("     , ?                                                ");
        str.append("     , ?                                                ");
        str.append("     , ?                                                ");
        str.append("     , ?                                                ");
        str.append("     , ?                                                ");
        str.append("     , ?                                                ");
        str.append(" )                                                      ");
        str.append(" ;                                                      ");

        jdbctemplate.update(str.toString(), gridcolumninfo.getPgmId()
                                          , gridcolumninfo.getColumnId()
                                          , gridcolumninfo.getColumnTitle()
                                          , gridcolumninfo.getColumnKey()
                                          , gridcolumninfo.getColumnType()
                                          , gridcolumninfo.getColumnAlign()
                                          , gridcolumninfo.getColumnLength());
    }

    @Override
    public void update(Gridcolumninfo gridcolumninfo) {
        StringBuffer str = new StringBuffer();

        str.append(" UPDATE                                                 ");
        str.append("     gridcolumninfo A                                   ");
        str.append(" SET                                                    ");
        str.append("       column_key    = COALESCE(?, A.column_key   )     ");
        str.append("     , column_type   = COALESCE(?, A.column_type  )     ");
        str.append("     , column_align  = COALESCE(?, A.column_align )     ");
        str.append("     , column_length = COALESCE(?, A.column_length)     ");
        str.append(" WHERE                                                  ");
        str.append("       pgm_id    = ?                                    ");
        str.append("   AND column_id = ?                                    ");
        str.append(" ;                                                      ");

        jdbctemplate.update(str.toString(), gridcolumninfo.getColumnKey()
                                          , gridcolumninfo.getColumnType()
                                          , gridcolumninfo.getColumnAlign()
                                          , gridcolumninfo.getColumnLength()
                                          , gridcolumninfo.getPgmId()
                                          , gridcolumninfo.getColumnId());
    }

    @Override
    public boolean isExistsCheckById(Gridcolumninfo gridcolumninfo) {
        StringBuffer str = new StringBuffer();

        str.append(" SELECT count(1)       ");
        str.append(" FROM   gridcolumninfo ");
        str.append(" WHERE  pgm_id    = ?  ");
        str.append("   AND  column_id = ?  ");

        Object[] params = new Object[] { gridcolumninfo.getPgmId(), gridcolumninfo.getColumnId() };

        int result = jdbctemplate.queryForObject(str.toString(), params, Integer.class);

        return (result > 0);
    }
}
