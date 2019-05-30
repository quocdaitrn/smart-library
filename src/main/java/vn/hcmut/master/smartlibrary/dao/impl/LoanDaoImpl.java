package vn.hcmut.master.smartlibrary.dao.impl;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import vn.hcmut.master.smartlibrary.dao.LoanDao;
import vn.hcmut.master.smartlibrary.dao.mapper.LibItemMapper;
import vn.hcmut.master.smartlibrary.model.*;
import vn.hcmut.master.smartlibrary.model.type.LibItemStatus;
import vn.hcmut.master.smartlibrary.model.type.LibItemType;
import vn.hcmut.master.smartlibrary.model.type.RoleName;
import vn.hcmut.master.smartlibrary.model.type.Sex;

import java.sql.Types;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;

@Component
public class LoanDaoImpl implements LoanDao {

    private Logger logger = LoggerFactory.getLogger(LibItemDaoImpl.class);

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public LoanDaoImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<Loan> findAll() {
        return null;
    }

    @Override
    public Optional<Loan> findById(Long id) {
        return Optional.empty();
    }

    @Override
    public Loan create(Loan obj) {
        final String sql = "INSERT INTO loans(user_id, lib_item_id, borrow_date, due_date, return_date, note) VALUES (?, ?, ?, ?, ?, ?)";
        jdbcTemplate.update(sql,
                obj.getUser().getId(),
                obj.getLibItem().getId(),
                obj.getBorrowDate(),
                obj.getDueDate(),
                obj.getReturnDate(),
                obj.getNote());

        return obj;
    }

    @Override
    public Loan update(Loan obj) {
        return null;
    }

    @Override
    public void delete(Loan obj) {

    }

    @Override
    public List<Loan> findByUserId(Long userId) {
        final String sql = "SELECT l.id AS loan_id, l.borrow_date, l.note, l.due_date, l.return_date, " +
                "u.id AS u_id, u.name AS u_name, u.username, u.email, u.sex, u.phone, u.role, " +
                "li.* " +
                "FROM loans AS l " +
                "JOIN lib_items AS li ON l.lib_item_id = li.id " +
                "JOIN users AS u ON l.user_id = u.id " +
                "WHERE l.user_id = ?";

        logger.debug(sql);

        final List<Map<String, Object>> rows = jdbcTemplate.queryForList(sql, userId);

        return mappingResultToList(rows);
    }

    @Override
    public void updateReturnDateByUserIdAndItemId(Long userId, Long libItemId) {
        Date now = Calendar.getInstance().getTime();
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        String today = dateFormat.format(now);

        final String sql = "UPDATE loans SET return_date = ? WHERE user_id = ? AND lib_item_id = ?";

        Object[] params = {today, userId, libItemId};
        int[] types = {Types.VARCHAR, Types.INTEGER, Types.INTEGER};

        jdbcTemplate.update(sql, params, types);
    }

    private List<Loan> mappingResultToList(List<Map<String, Object>> rows) {
        List<Loan> loans = new ArrayList<>();
        for (Map<String, Object> row : rows) {
            Loan loan = new Loan();
            loan.setId((Long) row.get("loan_id"));
            loan.setBorrowDate((Date) row.get("borrow_date"));
            loan.setNote((String) row.get("note"));
            loan.setDueDate((Date) row.get("due_date"));
            loan.setReturnDate((Date) row.get("return_date"));

            // set lib item
            LibItem libItem = LibItemMapper.map(row);

            Publisher publisher = new Publisher();
            publisher.setId((Long) row.get("publisher_id"));
            libItem.setPublisher(publisher);

            LibSection libSection = new LibSection();
            libSection.setId((Long) row.get("lib_section_id"));
            libItem.setLibSection(libSection);

            loan.setLibItem(libItem);

            // set user
            User user = new User();
            user.setId((Long) row.get("u_id"));
            user.setName((String) row.get("u_name"));
            user.setUsername((String) row.get("username"));
            user.setEmail((String) row.get("email"));
            user.setRole(RoleName.valueOf((String) row.get("role")));
            String sex = (String) row.get("sex");
            if (StringUtils.equals("M", sex)) {
                user.setSex(Sex.MALE);
            } else {
                user.setSex(Sex.FEMALE);
            }
            user.setPhone((String) row.get("phone"));

            loan.setUser(user);

            loans.add(loan);
        }

        return loans;
    }
}
