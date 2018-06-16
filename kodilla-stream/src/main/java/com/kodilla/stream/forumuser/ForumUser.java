package com.kodilla.stream.forumuser;

import java.time.LocalDate;

public final class ForumUser {
    private static int counter = 0;

    private final int id;
    private final String name;
    private final char sex;
    private final LocalDate birthDate;
    private final int postCount;

    public ForumUser(final String name, final char sex,
                     final LocalDate birthDate, final int postCount) {
        if (name == null || name.isEmpty() || (sex != 'M' && sex != 'F')
                || birthDate == null || postCount < 0)

            throw new IllegalArgumentException(" wrong argument");

        this.name = name;
        this.sex = sex;
        this.birthDate = birthDate;
        this.postCount = postCount;

        this.id = ++counter;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public char getSex() {
        return sex;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public int getPostCount() {
        return postCount;
    }

    @Override
    public String toString() {
        return "ForumUser{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", gender=" + sex +
                ", birthDate=" + birthDate +
                ", postCount=" + postCount +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ForumUser forumUser = (ForumUser) o;
        if (id != forumUser.id) return false;
        if (sex != forumUser.sex) return false;
        if (postCount != forumUser.postCount) return false;
        if (!name.equals(forumUser.name)) return false;
        return birthDate.equals(forumUser.birthDate);
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 20 * result + name.hashCode();
        result = 20 * result + (int) sex;
        result = 20 * result + birthDate.hashCode();
        result = 20 * result + postCount;
        return result;
    }
}