package jpabook.jpashop.domain.exam;

import javax.persistence.*;

@Entity
public class SportMan {

    @Id @GeneratedValue
    @Column(name = "MEMBER_ID")
    private Long id;

    private String name;

    @ManyToOne
    @JoinColumn(name = "TEAM_ID")
    private Team team;


    public SportMan(Long id, String name, Team team) {
        this.id = id;
        this.name = name;
        this.team = team;
    }

    public SportMan() {

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

    public Team getTeam() {
        return team;
    }

    public void setTeam(Team team) {
        this.team = team;
    }
}
