package ua.goit.jdbс.commands;

import ua.goit.jdbс.dto.SkillsDto;
import ua.goit.jdbс.exceptions.SkillAlreadyExistException;
import ua.goit.jdbс.service.SkillsService;
import ua.goit.jdbс.view.View;

public class UpdateSkill implements Command {
    public static final String UPDATE_SKILL = "update_skill";
    private final View view;
    private final SkillsService skillsService;

    public UpdateSkill(View view, SkillsService skillsService) {
        this.view = view;
        this.skillsService = skillsService;
    }

    @Override
    public boolean canExecute(String input) {
        return input.equals(UPDATE_SKILL);
    }

    @Override
    public void execute() {
        view.write("Enter ID by skill: ");
        int id = Integer.parseInt(view.read());
        view.write("Enter developer skill branch: ");
        String branch = view.read();
        view.write("Enter developer skill level: ");
        String skillLevel = view.read();
        while (true) {
            try {
                SkillsDto skill = new SkillsDto(id, branch, skillLevel);
                skillsService.update(skill);
                break;
            } catch (SkillAlreadyExistException exception) {
                view.write(exception.getMessage());
            }
        }
        view.write("Skill updated. Thank you!");
    }
}
