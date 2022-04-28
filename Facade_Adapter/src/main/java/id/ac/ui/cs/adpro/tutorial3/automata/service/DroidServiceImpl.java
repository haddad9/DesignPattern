package id.ac.ui.cs.adpro.tutorial3.automata.service;


import id.ac.ui.cs.adpro.tutorial3.automata.core.droid.Droid;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import id.ac.ui.cs.adpro.tutorial3.automata.core.droid.FluidDroid;
import id.ac.ui.cs.adpro.tutorial3.automata.core.droid.GolemDroid;
import id.ac.ui.cs.adpro.tutorial3.automata.core.fluids.Fluids;
import id.ac.ui.cs.adpro.tutorial3.automata.core.golem.Golem;
import id.ac.ui.cs.adpro.tutorial3.automata.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DroidServiceImpl implements DroidService {

    @Autowired
    private DroidRepository droidRepository;

    @Autowired
    private FluidsRepository fluidsRepository;

    @Autowired
    private GolemRepository golemRepository;

    @Autowired
    private InventoryRepository inventoryRepository;

    @Autowired
    private LoggerRepository loggerRepository;

    // Simpan semuanya
    private List<Droid> units = new ArrayList<>();


    /**
     * Mengambil seluruh droid yang tersimpan.
     * Note: Termasuk seluruh automata pengganti droid.
     *
     * @return List automata
     */
    @Override
    public List<Droid> fetchDroids() {

        // ----- Memasukkan adapter fluid ----- //

        for (Fluids fluid : fluidsRepository.findAll()){
            droidRepository.add(new FluidDroid(fluid));
            units.add(new FluidDroid(fluid));
        }
        fluidsRepository.findAll().clear();

        // ----- Memasukkan adapter golem ----- //

        for(Golem golem : golemRepository.findAll()){
            droidRepository.add(new GolemDroid(golem));
            units.add(new GolemDroid(golem));
        }
        golemRepository.findAll().clear();

        return droidRepository.findAll();
    }

    /**
     * Mengambil seluruh rekaman inventory yang tersimpan.
     *
     * @return List rekaman inventory
     */
    @Override
    public List<String> fetchInventories() {

        return inventoryRepository.fetchInventory();
    }

    /**
     * Menambahkan sebuah benda ke dalam inventory.
     *
     * @param item benda untuk ditambah
     */
    @Override
    public void addInventory(String item) {
        inventoryRepository.addItem(item);
        inventoryRepository.addUnique(item);
    }

    /**
     * Mengambil seluruh rekaman log yang tersimpan.
     *
     * @return List rekaman log
     */
    @Override
    public List<String> fetchLogs() {

        return loggerRepository.getLogs();
    }

    /**
     * Memanggil droid untuk melakukan sebuah rutinitas.
     *
     * @param droidName droid yang ingin dipanggil
     * @param routine   rutinitas yang akan dilakukan droid
     */
    @Override
    public void doRoutine(String droidName, int routine) {
        Droid droid = droidRepository.findByName(droidName);


        List<String> items = fetchInventories();
        switch (routine){
            case 0:
                for(String stuff : inventoryRepository.fetchInventory()){
                    recordLog(droid,droid.liftItem(stuff));
                }
                break;

            case 1 :
                Set<String> itemList = new HashSet<>();
                for (String item: items) {
                    if (!itemList.contains(item)) {
                        recordLog(droid, droid.countItem(items, item));
                        itemList.add(item);
                    }
                }
                break;

            case 2 :
                recordLog(droid,droid.useTransporter());
                break;

            case 3 :
                recordLog(droid,droid.useCrane());
                break;

            default:
                // unreachable, do nothing
        }
    }

    /**
     * Rekam sebuah Log dengan format: "<Nama droid>: <Aksi droid>"
     *
     * @param droid  Droid yang melakukan aksi
     * @param action Aksi yang dilakukan droid
     */
    protected void recordLog(Droid droid, String action) {
        loggerRepository.addRecord(String.format("%s: %s",droid.getName(),action));
    }
}