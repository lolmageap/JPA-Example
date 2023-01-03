package jpabook.jpashop.domain.exam;

import jpabook.jpashop.domain.Member;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Team {

    @Id @GeneratedValue
    @Column(name = "TEAM_ID")
    private Long id;
    private String name;
    @OneToMany(mappedBy = "team") // mappedBy = "team" -> "team"으로 매핑 되어있다는 뜻
    private List<SportMan> men = new ArrayList<>();

    public Team() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<SportMan> getMan() {
        return men;
    }

    public void setMan(List<SportMan> man) {
        this.men = man;
    }

    public Team(Long id, String name, List<SportMan> men) {
        this.id = id;
        this.name = name;
        this.men = men;
    }
}
