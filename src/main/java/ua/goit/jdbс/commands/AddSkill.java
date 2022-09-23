package ua.goit.jdbс.commands;

import ua.goit.jdbс.dto.SkillsDto;
import ua.goit.jdbс.exceptions.SkillAlreadyExistException;
import ua.goit.jdbс.repository.SkillsRepository;
import ua.goit.jdbс.service.SkillsService;
import ua.goit.jdbс.view.View;

public class AddSkill implements Command {
    public static final String ADD_SKILL = "add_skill";
    private final View view;
    private final SkillsService skillsService;

    public AddSkill(View view, SkillsService skillsService) {
        this.view = view;
        this.skillsService = skillsService;
    }

    @Override
    public boolean canExecute(String input) {
        return input.equals(ADD_SKILL);
    }

    @Override
    public void execute() {
        view.write("Enter developer skill branch and skill level separated by a '/': ");
        String[] skillColumns = view.read().split("/");
        String branch = null;
        String skillLevel = null;
        if (skillColumns.length == skillsService.getCountOfColumn(SkillsRepository.TABLE_NAME) - 1) {
            for (int i = 0; i <= skillColumns.length - 1; i++) {
                String s = skillColumns[i].replace(",", "").strip();
                skillColumns[i] = s;
                switch (i) {
                    case 0 -> branch = skillColumns[i];
                    case 1 -> skillLevel = skillColumns[i];
                }
            }
            while (true) {
                try {
                    SkillsDto skill = new SkillsDto(branch, skillLevel);
                    skillsService.save(skill);
                    break;
                } catch (SkillAlreadyExistException exception) {
                    view.write(exception.getMessage());
                }
            }
            view.write("Skill added. Thank you!");
        } else {view.write("Skill not added. Thank you!");}
    }
}
