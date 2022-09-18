package ua.goit.jdbс.commands;

import ua.goit.jdbс.dto.SkillsDto;
import ua.goit.jdbс.service.SkillsService;
import ua.goit.jdbс.view.View;

public class FindSkill implements Command {
    public static final String FIND_SKILL = "find_skill";
    private final View view;
    private final SkillsService skillsService;

    public FindSkill(View view, SkillsService skillsService) {
        this.view = view;
        this.skillsService = skillsService;
    }

    @Override
    public boolean canExecute(String input) {
        return input.equals(FIND_SKILL);
    }

    @Override
    public void execute() {
        view.write("Enter ID by skill: ");
        int id = Integer.parseInt(view.read());
        while (true) {
            try {
                SkillsDto skill = skillsService.findById(id);
                System.out.println(skill);
                break;
            } catch (RuntimeException exception) {
                view.write(exception.getMessage());
            }
        }
        view.write("Skill found. Thank you!");
    }
}
