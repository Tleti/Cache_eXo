package org.exoplatform.cahe.tqa;


import org.exoplatform.container.PortalContainer;
import org.exoplatform.services.cache.CacheService;
import org.exoplatform.services.cache.ExoCache;
import org.exoplatform.services.cache.ExoCacheConfig;
import org.exoplatform.services.cache.ExoCacheFactory;
import org.picocontainer.Startable;
/**
 * Created by IntelliJ IDEA.
 * User: Tleti
 * Date: 26/11/12
 * Time: 17:45
 * To change this template use File | Settings | File Templates.
 */

public class CacheTqa implements Startable {
    static PortalContainer portalContainer;
    ExoCacheFactory exoCacheFactory;

    public CacheTqa(PortalContainer portalContainer, ExoCacheFactory exoCacheFactory) throws Exception {
        this.portalContainer = portalContainer;
        this.exoCacheFactory= exoCacheFactory;
    }

    public void start() {
        try {
        CacheService service_;
        service_ = (CacheService) PortalContainer.getInstance().getComponentInstanceOfType(CacheService.class);
        ExoCache<String, Object> cacheTqa = service_.getCacheInstance("TQA-TN");
        ExoTqa tqa1 = new ExoTqa("TQA_1", "TQA_A");
        ExoTqa tqa2 = new ExoTqa("TQA_2", "TQA_B");
        System.out.println();System.out.println();System.out.println();System.out.println();
        cacheTqa.put("a", tqa1);
        System.out.println("##########cache put :  a->tqa1(TQA_1\", \"TQA_A\")");
        cacheTqa.put("b", tqa2);
        System.out.println("########## cache put  :  b->tqa1(TQA_2\", \"TQA_B\")");
        System.out.println("##############  cacheTqa.getCacheSize())   " + cacheTqa.getCacheSize());
        System.out.println("##############  cacheTqa.getMaxSize())  " + cacheTqa.getMaxSize());
        System.out.println("############## get from cache cacheTqa.get(\"a\")  : " + ((ExoTqa) cacheTqa.get("a")).toString());
        System.out.println();System.out.println();System.out.println();
        /*
        *
        *##########cache put :  a->tqa1(TQA_1", "TQA_A")
        ########## cache put  :  b->tqa1(TQA_2", "TQA_B")
        ##############  cacheTqa.getCacheSize())   2
        ##############  cacheTqa.getMaxSize())  2135
        ############## get from cache cacheTqa.get("a")  :  name = TQA_1  and path = TQA_A

        *
        *
        * */
        ExoCacheConfig config = new ExoCacheConfig();
              config.setName("aaa");
              config.setMaxSize(5);
              config.setLiveTime(100);


            ExoCache<String, Object> cache1 = exoCacheFactory.createCache(config);

            System.out.println();System.out.println();System.out.println();
            cache1.put("a", "tqa1");
            System.out.println("############## acache1.put(\"a\", \"tqa1\")  : " + (cache1.get("a")).toString());
            System.out.println();System.out.println();System.out.println();

            /*############## acache1.put("a", "tqa1")  : tqa1
            */

        } catch (Exception e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }
    }





    public void stop() {
    }
}


