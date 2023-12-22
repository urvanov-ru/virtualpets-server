package ru.urvanov.virtualpets.server.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ru.urvanov.virtualpets.server.dao.MachineWithDrinksDao;
import ru.urvanov.virtualpets.server.domain.MachineWithDrinks;

@Service(value="machineWithDrinksService")
public class MachineWithDrinksServiceImpl implements MachineWithDrinksService {

    @Autowired
    private MachineWithDrinksDao machineWithDrinksDao;

    @Override
    public MachineWithDrinks findById(Integer id) {
        return machineWithDrinksDao.findById(id);
    }

    @Override
    public MachineWithDrinks findFullById(Integer id) {
        return machineWithDrinksDao.findFullById(id);
    }

    /**
     * @return the drinkDao
     */
    public MachineWithDrinksDao getDrinkDao() {
        return machineWithDrinksDao;
    }

    /**
     * @param drinkDao the drinkDao to set
     */
    public void setDrinkDao(MachineWithDrinksDao drinkDao) {
        this.machineWithDrinksDao = drinkDao;
    }

}
